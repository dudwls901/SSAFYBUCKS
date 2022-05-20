package com.ssafy.smartstore.view.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.R
import com.ssafy.smartstore.adapter.OrderDetailAdapter
import com.ssafy.smartstore.databinding.FragmentShoppingListBinding
import com.ssafy.smartstore.event.EventObserver
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.WindowState
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.*
import kr.co.bootpay.Bootpay
import kr.co.bootpay.BootpayAnalytics
import kr.co.bootpay.enums.Method
import kr.co.bootpay.enums.PG
import kr.co.bootpay.enums.UX
import kr.co.bootpay.model.BootExtra
import kr.co.bootpay.model.BootUser
import kr.co.bootpay.model.Item

private const val TAG = "ShoppingListFragment"

class ShoppingListFragment : Fragment(), CoroutineScope, ShoppingListDeleteClickListener {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var userId: String
    private lateinit var binding: FragmentShoppingListBinding
    private lateinit var adapter: OrderDetailAdapter

    private var items = mutableListOf<Item>()
    private var orderName: String? = null
    private var orderPrice = 0

    private val orderViewModel: OrderViewModel by activityViewModels()

    //부트페이
    val application_id = "628718fbe38c300020ad1c04"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingListBinding.inflate(inflater, container, false)

        val prefs = requireActivity().getSharedPreferences("data", Context.MODE_PRIVATE)
        userId = prefs.getString("id", "") ?: ""

        observeDatas()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.orderVM = orderViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        userId?.let {
            orderViewModel.getShoppingList(it)
        }

        BootpayAnalytics.init(requireActivity(), application_id)

        initViews()

    }

    fun goBootpayRequest() {
        val bootUser = BootUser().setPhone("010-1234-5678")
        val bootExtra = BootExtra().setQuotas(intArrayOf(0, 2, 3))

        val stuck = 1 //재고 있음

        Bootpay.init(requireActivity())
            .setApplicationId(application_id) // 해당 프로젝트(안드로이드)의 application id 값
            .setContext(requireActivity())
            .setBootUser(bootUser)
            .setBootExtra(bootExtra)
            .setUX(UX.PG_DIALOG)
            .setPG(PG.INICIS)
            .setMethod(Method.CARD)
//                .setUserPhone("010-1234-5678") // 구매자 전화번호
            .setName(orderName) // 결제할 상품명
            .setOrderId("1234") // 결제 고유번호expire_month
            .setPrice(orderPrice) // 결제할 금액
            .addItems(items)
            .onConfirm { message ->
                if (0 < stuck) Bootpay.confirm(message); // 재고가 있을 경우.
                else Bootpay.removePaymentWindow(); // 재고가 없어 중간에 결제창을 닫고 싶을 경우
                Log.d("confirm", message);
            }
            .onDone { message ->
                launch {
                    withContext(Dispatchers.IO) {
                        orderViewModel.updateOrderDetails(userId)
                    }
                    Log.d(TAG, "goBootpayRequest: finish")
                    findNavController().popBackStack()
                }
                Log.d("done", message)
            }
            .onReady { message ->
                Log.d("ready", message)
            }
            .onCancel { message ->
                Log.d("cancel", message)
            }
            .onError { message ->
                Log.d("error", message)
            }
            .onClose { message ->
                Log.d("close", "close")
            }
            .request()
    }


    private fun observeDatas() {
        orderViewModel.shoppingList.observe(viewLifecycleOwner) {
            updateShoppingList(it)
        }

        orderViewModel.dialogMessage.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { message ->
                Log.d(TAG, "observeDatas: dialog ${message}")
                createDialog(message)
            }
        }

        //결제창 띄우기
        orderViewModel.canCallBootPay.observe(viewLifecycleOwner, EventObserver{
            if(it){
                goBootpayRequest()
            }
        })
    }

    // 다이얼로그 띄우는 함수
    private fun createDialog(message: Map<String, Any>) {
        val builder =
            AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
        builder.setTitle(message.get("title") as String)
        builder.setMessage(message.get("message") as String)
        builder.setIcon(R.mipmap.ic_launcher)

        builder.setPositiveButton("확인", null)
        builder.show()
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        // 주문상세 리사이클러뷰 연결
        adapter = OrderDetailAdapter(WindowState.SHOPPINGLIST, this@ShoppingListFragment).apply {
            setHasStableIds(false)

            rvOrderList.adapter = this
            rvOrderList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        // 주문하기 버튼
        btnOrder.setOnClickListener {
            orderViewModel.makeOrder()
//            val result = orderViewModel.makeOrder(userId).await()
//            if (result) {
//                findNavController().popBackStack()
//            }
        }
    }

    // 장바구니 리스트 데이터 업데이트
    private fun updateShoppingList(shoppingList: List<OrderProduct>) {
        orderPrice = 0
        items = mutableListOf()
//        Log.d(TAG, "updateShoppingList: ${shoppingList.join}")
        if (shoppingList.isNotEmpty()) {
            val size = shoppingList.size
            if (size > 1) {
                orderName = "${shoppingList[0].product.name}외 ${size - 1}잔"
            } else {
                orderName = shoppingList[0].product.name
            }
        }
        shoppingList.forEach {
            orderPrice += (it.product.price) * it.quantity
            items.add(
                Item(
                    it.product.name,
                    it.quantity,
                    it.product.type,
                    it.product.price.toDouble(),
                    "",
                    "",
                    ""
                )
            )
        }
        //어댑터 갱신
        adapter.submitList(shoppingList)
    }

    // 아이템 삭제 버튼 클릭시
    override fun onShoppingListDeleteClickListener(productId: Int) {
        val map = hashMapOf<String, Any>(Pair("userId", userId), Pair("productId", productId))
        orderViewModel.deleteOneItem(map)
    }
}
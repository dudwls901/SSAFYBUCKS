package com.ssafy.smartstore.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.R
import com.ssafy.smartstore.adapter.OrderDetailAdapter
import com.ssafy.smartstore.databinding.FragmentShoppingListBinding
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.WindowState
import com.ssafy.smartstore.viewmodel.OrderViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "ShoppingListFragment"

class ShoppingListFragment : Fragment(), CoroutineScope, ShoppingListDeleteClickListener {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var userId: String
    private lateinit var binding: FragmentShoppingListBinding
    private lateinit var adapter: OrderDetailAdapter

    private val orderViewModel: OrderViewModel by activityViewModels()

    private lateinit var callback: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

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

        initViews()

//        // 2가지방법 - 1. by navArgs()
//        val safeArgs: ShoppingListFragmentArgs by navArgs()
//        orderInfo = safeArgs.orderInfo
//        orderProduct = safeArgs.orderProduct
//        if (orderInfo != null) {
//            shoppingList.customAdd(orderInfo!!.orderProductList) // List<orderProduct>
//        }
//
//        if (orderProduct != null) {
//            shoppingList.customAdd(orderProduct!!)
//        }
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    private fun observeDatas() {
        orderViewModel.shoppingList.observe(viewLifecycleOwner) {
            updateShoppingList(it)
        }

        orderViewModel.toastMessage.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        orderViewModel.dialogMessage.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { message ->
                createDialog(message)
            }
        }
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
            launch {
                val result = orderViewModel.makeOrder(userId).await()
                if (result) {
                    findNavController().popBackStack()
                }
            }
        }
    }

    // 장바구니 리스트 데이터 업데이트
    private fun updateShoppingList(shoppingList: List<OrderProduct>) {
        //어댑터 갱신
        adapter.submitList(shoppingList)
        binding.rvOrderList.adapter = adapter
    }

    // 아이템 삭제 버튼 클릭시
    override fun onShoppingListDeleteClickListener(productId: Int) {
        val map = hashMapOf<String, Any>(Pair("userId", userId), Pair("productId", productId))
        orderViewModel.deleteOneItem(map)
    }
}
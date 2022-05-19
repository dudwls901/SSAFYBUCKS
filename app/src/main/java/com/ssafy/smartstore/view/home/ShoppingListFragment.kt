package com.ssafy.smartstore.view.home

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.R
import com.ssafy.smartstore.StoreApplication
import com.ssafy.smartstore.adapter.OrderDetailAdapter
import com.ssafy.smartstore.data.local.repository.OrderRepository
import com.ssafy.smartstore.data.remote.dto.Order
import com.ssafy.smartstore.databinding.FragmentShoppingListBinding
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.model.OrderDetail
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.WindowState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListFragment : Fragment(), ShoppingListDeleteClickListener {
    private lateinit var binding: FragmentShoppingListBinding

    private lateinit var adapter: OrderDetailAdapter
    private lateinit var orderList: MutableList<OrderDetail>
    private var orderInfo: OrderInfo? = null
    private var orderProduct: OrderProduct? = null
    private lateinit var shoppingList: ArrayList<OrderProduct>

    private lateinit var orderRepo: OrderRepository

    private var user_id = ""

    private lateinit var nfcAdapter: NfcAdapter
    private lateinit var pIent: PendingIntent
    private lateinit var filters: Array<IntentFilter>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoppingListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderRepo = OrderRepository.getInstance()

        val prefs = requireActivity().getSharedPreferences("data", AppCompatActivity.MODE_PRIVATE)
        user_id = prefs.getString("id", "") ?: ""

        initOrderDetailList()


        shoppingList = StoreApplication.shoppingList


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

        initViews()

    }


    private fun initOrderDetailList() {
        orderList = mutableListOf(
            OrderDetail(1, "아메리카노", 4000, 2),
            OrderDetail(2, "아메리카", 5000, 3),
            OrderDetail(3, "아메리", 6000, 1),
            OrderDetail(4, "아메", 7000, 3),
            OrderDetail(5, "아", 8000, 2),
        )
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        var priceSum = 0
        var orderCount = 0

        for (orderProduct in shoppingList) {
            orderCount += orderProduct.quantity
            priceSum += orderProduct.quantity * orderProduct.product.price
        }

        tvPriceSum.text = "총 ${orderCount}개"
        tvOrderCount.text = "${priceSum}원"

        // 주문상세 리사이클러뷰 연결
        adapter = OrderDetailAdapter(WindowState.SHOPPINGLIST, this@ShoppingListFragment).apply {
            setHasStableIds(true)
            submitList(shoppingList)

            rvOrderList.adapter = this
            rvOrderList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        // 주문하기 버튼
        btnOrder.setOnClickListener {
            // {orders=[{id=1, name=coffee1, type=coffee, price=1, img=coffee1.png, count=2}, {id=5, name=coffee5, type=coffee, price=5, img=coffee5.png, count=3}], userId=123}
            // orders의 id : prodcutId, count : quantity
            if (!StoreApplication.shoppingList.isEmpty()) {
                val data = StoreApplication.shoppingList

                if (StoreApplication.orderTable == "") {
                    val builder =
                        AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
                    builder.setTitle("알림")
                    builder.setMessage("Table NFC를 먼저 찍어주세요")
                    builder.setIcon(R.mipmap.ic_launcher)

                    builder.setPositiveButton("확인", null)
                    builder.show()
                } else {
                    val order = Order(user_id, StoreApplication.orderTable)
                    val orderDetails =
                        mutableListOf<com.ssafy.smartstore.data.remote.dto.OrderDetail>()
                    data.forEach {
                        val orderDetail =
                            com.ssafy.smartstore.data.remote.dto.OrderDetail(
                                it.product.id,
                                it.quantity
                            )
                        orderDetails.add(orderDetail)
                    }
                    order.details = orderDetails

                    StoreApplication.shoppingList = ArrayList<OrderProduct>()

                    CoroutineScope(Dispatchers.Main).launch {
                        com.ssafy.smartstore.data.remote.repository.OrderRepository.INSTANCE.makeOrder(
                            order
                        )
                        Toast.makeText(requireContext(), "주문이 완료되었습니다", Toast.LENGTH_SHORT)
                            .show()
//                        finish()
                    }

                    Intent(requireContext(), HomeActivity::class.java).apply {
                        putExtra("refresh", true)
                        startActivity(this)
//                        finish()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "상품을 담아주세요", Toast.LENGTH_SHORT)
                    .show()
//                finish()
            }
        }
    }


    override fun onShoppingListDeleteClickListener(position: Int) {
        shoppingList.removeAt(position)

        initViews()

    }

}
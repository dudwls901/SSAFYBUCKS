package com.ssafy.smartstore.view.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.adapter.OrderDetailAdapter
import com.ssafy.smartstore.databinding.ActivityOrderDetailBinding
import com.ssafy.smartstore.model.OrderDetail
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.util.WindowState.ORDERDETAIL

// F08: 주문관리 - 주문 상세 조회 - 주문 번호에 기반하여 주문을 조회할 수 있다. 이때 주문 상세 항목들 어떤 상품이 몇개 주문 되었는지에 대한 정보도 포함한다.

private const val TAG = "OrderDetailActivity_싸피"

class OrderDetailActivity : AppCompatActivity(), ShoppingListDeleteClickListener {
    private lateinit var binding: ActivityOrderDetailBinding

    private lateinit var adapter: OrderDetailAdapter
    private lateinit var orderList: MutableList<OrderDetail>
    private lateinit var orderInfo: OrderInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("orderInfo")
        orderInfo = bundle?.getParcelable<OrderInfo>("orderInfo") as OrderInfo

        Log.d(TAG, "onCreate: ${orderInfo}")

        initViews()
    }


    //뷰들 초기화
    @SuppressLint("SetTextI18n")
    private fun initViews() = with(binding) {

        tvDate.text = orderInfo.date
        var totalPrice = 0
        orderInfo.orderProductList.forEach { orderProduct->
            totalPrice += orderProduct.quantity * orderProduct.product.price
        }
        tvPrice.text = "${totalPrice}원"

        // 주문 상세 리사이클러뷰 연결
        adapter = OrderDetailAdapter(ORDERDETAIL,this@OrderDetailActivity).apply {
            setHasStableIds(true)
            submitList(orderInfo.orderProductList)

            rvOrderList.adapter = this
            rvOrderList.layoutManager =
                LinearLayoutManager(this@OrderDetailActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onShoppingListDeleteClickListener(position: Int) {}
}
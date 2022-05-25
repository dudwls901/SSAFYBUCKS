package com.ssafy.smartstore.view.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.adapter.OrderDetailAdapter
import com.ssafy.smartstore.databinding.FragmentOrderDetailBinding
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.model.OrderDetail
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.util.DateFormatter.formatDate
import com.ssafy.smartstore.util.DecimalConverter.priceConvert
import com.ssafy.smartstore.util.WindowState

class OrderDetailFragment : Fragment(), ShoppingListDeleteClickListener {
    private lateinit var binding: FragmentOrderDetailBinding

    private lateinit var adapter: OrderDetailAdapter
    private lateinit var orderList: MutableList<OrderDetail>
    private lateinit var orderInfo: OrderInfo


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderDetailBinding.inflate(inflater, container, false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val bundle = intent.getBundleExtra("orderInfo")
//        orderInfo = bundle?.getParcelable<OrderInfo>("orderInfo") as OrderInfo
        // 2가지방법 - 1. by navArgs()
        val safeArgs: OrderDetailFragmentArgs by navArgs()
        orderInfo = safeArgs.orderInfo

        initViews()
    }



    //뷰들 초기화
    @SuppressLint("SetTextI18n")
    private fun initViews() = with(binding) {

        tvDate.text = orderInfo.date.formatDate()
        var totalPrice = 0
        orderInfo.orderProductList.forEach { orderProduct->
            totalPrice += orderProduct.quantity * orderProduct.product.price
        }
        tvPrice.text = "총 ${totalPrice.priceConvert()}원"

        // 주문 상세 리사이클러뷰 연결
        adapter = OrderDetailAdapter(WindowState.ORDERDETAIL,this@OrderDetailFragment).apply {
            setHasStableIds(true)
            submitList(orderInfo.orderProductList)

            rvOrderList.adapter = this
            rvOrderList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onShoppingListDeleteClickListener(position: Int) {}
}
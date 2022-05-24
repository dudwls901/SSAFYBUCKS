package com.ssafy.admin_final_gumi0607_09.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.databinding.RvOrderInfoBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo

import com.ssafy.smartstore.util.ImageConverter

private const val TAG = "MenuDetailAdapter___"

class OrderAdapter(val onSendPushClicked: (Int, String, String,String) -> Unit) : ListAdapter<OrderInfo, OrderAdapter.ItemViewHolder>(diffUtil) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderAdapter.ItemViewHolder = ItemViewHolder(
        RvOrderInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

//    private var context: Context? = null
    //context 가져오기
//    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//        super.onAttachedToRecyclerView(recyclerView)
//        context = recyclerView.context
//    }

    override fun onBindViewHolder(holder: OrderAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    inner class ItemViewHolder(private val binding: RvOrderInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(orderInfo: OrderInfo) {
            binding.orderInfo=orderInfo
            binding.isExpanded = false
            var price = 0
            var sumQuantity = 0
            for (orderProduct in orderInfo.orderProductList) {
                Log.d(TAG, "bind: ${orderProduct}")
                price += orderProduct.quantity * orderProduct.product.price
                sumQuantity += orderProduct.quantity
            }

            val orderText = if (sumQuantity == 1) {
                "${orderInfo.orderProductList[0].product.name} ${sumQuantity}잔"
            } else {
                "${orderInfo.orderProductList[0].product.name}외 ${sumQuantity - 1}잔"
            }

            val adapter = MenuAdapter()

            binding.tvContent.text = "주문 내역 : ${orderText}"
            binding.tvPrice.text = "주문 금액 : ${price}원"
            val yymm = orderInfo.date.substring(orderInfo.date.indexOf('T')+1,orderInfo.date.indexOf('T')+6 ).split(":")
            binding.tvDate.text = "주문 시간 : ${yymm[0]}시 ${yymm[1]}분"
            binding.rvMenu.adapter = adapter
            (binding.rvMenu.layoutManager as GridLayoutManager).apply {
                if(orderInfo.completed=="N")
                     spanCount=2
                else
                    spanCount=3
            }
            binding.ibExpand.setOnClickListener {

                when(binding.isExpanded){
                    true -> binding.isExpanded = false
                    false -> binding.isExpanded = true
                }
            }

            adapter.submitList(orderInfo.orderProductList)


            binding.btnItem.setOnClickListener {
                onSendPushClicked(orderInfo.id,orderInfo.user_id, "싸피벅스", "주문하신 상품이 나왔어요!!")
            }
            Log.d(TAG, "bind: ${orderInfo.completed}")
            if(orderInfo.completed=="Y") {
                binding.btnItem.visibility = View.GONE
            }
            else{
                binding.btnItem.visibility = View.VISIBLE
            }
        }
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderInfo>() {
            override fun areItemsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                return oldItem == newItem
            }

        }
    }
}
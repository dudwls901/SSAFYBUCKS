package com.ssafy.admin_final_gumi0607_09.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.databinding.RvOrderInfoBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo

import com.ssafy.smartstore.util.ImageConverter

private const val TAG = "MenuDetailAdapter___"

class OrderAdapter() : ListAdapter<OrderInfo, OrderAdapter.ItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderAdapter.ItemViewHolder = ItemViewHolder(
        RvOrderInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: OrderAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    inner class ItemViewHolder(private val binding: RvOrderInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
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

            binding.tvContent.text = orderText
            binding.tvPrice.text = price.toString()
            binding.tvDate.text = orderInfo.date.substring(0, orderInfo.date.indexOf('T'))
            binding.rvMenu.adapter = adapter
            (binding.rvMenu.layoutManager as GridLayoutManager).apply {
                if(orderInfo.completed=="N")
                     spanCount=3
                else
                    spanCount=4
            }

//            binding.rvMenu.layoutManager = GridLayoutManager()
            adapter.submitList(orderInfo.orderProductList)
//            ImageConverter.imageMap[product.img]?.let {
//                binding.rvImage.setImageResource(
//                    it
//                )
//            }
//            binding.rvName.text = product.name
//            binding.tvPrice.text = "${product.price}원"
        }
    }

    interface ItemOnClickListener {
        fun onClick(view: View, position: Int)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderInfo>() {
            override fun areItemsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                TODO("Not yet implemented")
            }

        }
    }
}
package com.ssafy.smartstore.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.smartstore.databinding.RvOrderItemBinding
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.listener.OrderListClickListener
import com.ssafy.smartstore.util.DecimalConverter.priceConvert
import com.ssafy.smartstore.util.ImageConverter
import com.ssafy.smartstore.util.WindowState.HOME
import com.ssafy.smartstore.util.WindowState.MYPAGE
import java.lang.Exception

private const val TAG = "OrderListAdapter_싸피"

class OrderListAdapter(val state: String, val listener: OrderListClickListener) :
    ListAdapter<OrderInfo, OrderListAdapter.ItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderListAdapter.ItemViewHolder = ItemViewHolder(
        RvOrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: OrderListAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ItemViewHolder(private val binding: RvOrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(order: OrderInfo) {
            try {
                var price = 0
                var sumQuantity = 0
                for (orderProduct in order.orderProductList) {
                    Log.d(TAG, "bind: ${orderProduct}")
                    price += orderProduct.quantity * orderProduct.product.price
                    sumQuantity += orderProduct.quantity
                }

                val orderText = if (sumQuantity == 1) {
                    "${order.orderProductList[0].product.name} ${sumQuantity}잔"
                } else {
                    "${order.orderProductList[0].product.name}외 ${sumQuantity - 1}잔"
                }

                if (order.completed == "N") {
                    binding.btnState.text = "주문 접수중"
                } else binding.btnState.text = "주문 완료"

                binding.tvOrderName.text = orderText
                binding.tvOrderPrice.text = "\uD83D\uDCB0"+price.priceConvert()
                binding.tvOrderDate.text = order.date.substring(0, order.date.indexOf('T'))
                ImageConverter.imageMap[order.orderProductList[0].product.img]?.let {
                    binding.ivImage.setImageResource(
                        it
                    )


                    binding.ivCart.setOnClickListener {
                        listener.onOrderListCartClickListener(order)
                    }
                    binding.orderListItem.setOnClickListener {
                        listener.onOrderListClickListener(order)
                    }

                }

                when (state) {
                    HOME -> binding.btnState.visibility = View.GONE
                    MYPAGE -> binding.ivCart.visibility = View.GONE
                }
            } catch (e: Exception) {

            }

        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderInfo>() {
            //먼저 비교
            override fun areItemsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                return oldItem.id == newItem.id
            }

            //나중 비교
            override fun areContentsTheSame(oldItem: OrderInfo, newItem: OrderInfo): Boolean {
                return oldItem == newItem
            }
        }
    }

}
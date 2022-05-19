package com.ssafy.smartstore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.smartstore.databinding.RvOrderDetailBinding
import com.ssafy.smartstore.dto.OrderDetail
import com.ssafy.smartstore.dto.OrderProduct
import com.ssafy.smartstore.global.windowState
import com.ssafy.smartstore.listener.ShoppingListDeleteClickListener
import com.ssafy.smartstore.util.ImageConverter

class OrderDetailAdapter(val state: String, val shoppingListDeleteClickListener: ShoppingListDeleteClickListener)  : ListAdapter<OrderProduct, OrderDetailAdapter.ItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderDetailAdapter.ItemViewHolder = ItemViewHolder(
        RvOrderDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: OrderDetailAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position],position)
    }

    inner class ItemViewHolder(private val binding: RvOrderDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(orderProduct: OrderProduct, position: Int) {
            binding.tvOrderName.text = orderProduct.product.name
            binding.tvOrderPrice.text = orderProduct.product.price.toString()
            binding.tvOrderQuantitiy.text = orderProduct.quantity.toString()
            binding.tvTotalPrice.text = (orderProduct.quantity * orderProduct.product.price).toString()

            ImageConverter.imageMap[orderProduct.product.img]?.let {
                binding.ivItem.setImageResource(
                    it
                )

                binding.btnClose.setOnClickListener {
                    shoppingListDeleteClickListener.onShoppingListDeleteClickListener(position)
                }

            }

            when (state){
                windowState.ORDERDETAIL-> binding.btnClose.visibility = View.GONE
                windowState.SHOPPINGLIST -> binding.btnClose.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderProduct>() {
            //먼저 비교
            override fun areItemsTheSame(oldItem: OrderProduct, newItem: OrderProduct): Boolean {
                return oldItem.product.id == newItem.product.id
            }

            //나중 비교
            override fun areContentsTheSame(oldItem: OrderProduct, newItem: OrderProduct): Boolean {
                return oldItem == newItem
            }
        }
    }
}
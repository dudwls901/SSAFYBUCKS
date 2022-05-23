package com.ssafy.admin_final_gumi0607_09.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.databinding.RvOrderInfoBinding
import com.ssafy.admin_final_gumi0607_09.databinding.RvOrderInfoMenuBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo
import com.ssafy.admin_final_gumi0607_09.model.OrderProduct

import com.ssafy.smartstore.util.ImageConverter

private const val TAG = "MenuDetailAdapter___"

class MenuAdapter() : ListAdapter<OrderProduct, MenuAdapter.ItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuAdapter.ItemViewHolder = ItemViewHolder(
        RvOrderInfoMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MenuAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ItemViewHolder(private val binding: RvOrderInfoMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(orderProduct: OrderProduct) {
            binding.orderProduct=orderProduct

            ImageConverter.imageMap[orderProduct.product.img]?.let {
                binding.ivMenu.setImageResource(
                    it
                )
            }
        }
    }

    interface ItemOnClickListener {
        fun onClick(view: View, position: Int)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderProduct>() {
            override fun areItemsTheSame(oldItem: OrderProduct, newItem: OrderProduct): Boolean {
                return oldItem.product.name == newItem.product.name
            }

            override fun areContentsTheSame(oldItem: OrderProduct, newItem: OrderProduct): Boolean {
                return oldItem == newItem
            }

        }
    }
}
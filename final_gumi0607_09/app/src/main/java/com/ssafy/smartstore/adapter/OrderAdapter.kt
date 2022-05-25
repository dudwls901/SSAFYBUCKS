package com.ssafy.smartstore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.smartstore.databinding.RvMenuItemBinding
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.util.DecimalConverter.priceConvert
import com.ssafy.smartstore.util.ImageConverter

private const val TAG = "MenuDetailAdapter___"

class OrderAdapter() : ListAdapter<Product, OrderAdapter.ItemViewHolder>(diffUtil) {

    lateinit var itemOnClickListener: ItemOnClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderAdapter.ItemViewHolder = ItemViewHolder(
        RvMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: OrderAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.itemView.setOnClickListener {
            itemOnClickListener.onClick(holder.itemView,position)
        }
    }

    inner class ItemViewHolder(private val binding: RvMenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            ImageConverter.imageMap[product.img]?.let {
                binding.rvImage.setImageResource(
                    it
                )
            }
            binding.rvName.text = product.name
            binding.tvPrice.text = "${product.price.priceConvert()}원"
        }
    }

    interface ItemOnClickListener {
        fun onClick(view: View, position: Int)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

        }
    }
}
package com.ssafy.smartstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.smartstore.databinding.RvNotiBinding
import com.ssafy.smartstore.listener.NotiDeleteClickListener
import com.ssafy.smartstore.data.local.dto.Noti

class NotiAdapter(private val notiDeleteClickListener: NotiDeleteClickListener) : ListAdapter<Noti, NotiAdapter.ItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotiAdapter.ItemViewHolder = ItemViewHolder(
        RvNotiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: NotiAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ItemViewHolder(private val binding: RvNotiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Noti) {
            binding.tvNoti.text = item.data
            binding.ivClose.setOnClickListener {
                notiDeleteClickListener.onNotiDeleteClickListener(item.id)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Noti>() {
            override fun areItemsTheSame(oldItem: Noti, newItem: Noti): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Noti, newItem: Noti): Boolean {
                return oldItem == newItem
            }

        }
    }
}
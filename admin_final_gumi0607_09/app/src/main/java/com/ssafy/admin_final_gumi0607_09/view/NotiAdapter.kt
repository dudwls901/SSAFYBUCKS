package com.ssafy.admin_final_gumi0607_09.view

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.admin_final_gumi0607_09.data.local.entity.Noti
import com.ssafy.admin_final_gumi0607_09.databinding.RvNotiListBinding
import com.ssafy.admin_final_gumi0607_09.databinding.RvOrderInfoBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo

class NotiAdapter: ListAdapter<Noti, NotiAdapter.ItemViewHolder>(diffUtil) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotiAdapter.ItemViewHolder = ItemViewHolder(
        RvNotiListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

//    private var context: Context? = null
    //context 가져오기
//    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//        super.onAttachedToRecyclerView(recyclerView)
//        context = recyclerView.context
//    }

    override fun onBindViewHolder(holder: NotiAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    inner class ItemViewHolder(private val binding: RvNotiListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(noti: Noti) {
            binding.noti= noti

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
package com.ssafy.admin_final_gumi0607_09.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.admin_final_gumi0607_09.databinding.RvUserBinding
import com.ssafy.admin_final_gumi0607_09.util.DecimalConverter.priceConvert
import com.ssafy.smartstore.util.ImageConverter

class UserAdapter : ListAdapter<HashMap<String, Any>, UserAdapter.ItemViewHolder>(diffUtil) {

//    lateinit var itemOnClickListener: ItemOnClickListener

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.ItemViewHolder = ItemViewHolder(
        RvUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ItemViewHolder(val binding: RvUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HashMap<String, Any>) {
            val gradeItem = item.get("grade") as Map<String, Any>
            ImageConverter.imageMap[gradeItem["img"] as String]?.let {
                binding.ivGrade.setImageResource(
                    it
                )
            }
            binding.tvId.text = item.get("id") as String
            binding.tvName.text = item.get("name") as String
            binding.tvStamp.text = "총 " + (gradeItem.get("stamp") as Double).toInt() + "잔"
            binding.tvTotal.text = "총 " + (item.get("total") as Double).toInt().priceConvert() + "원"
            if (gradeItem.get("title") as String == "커피나무") {
                binding.tvGrade.text =
                    gradeItem.get("title") as String
                binding.ivVip.rotation = 30.0f
            } else {
                binding.tvGrade.text =
                    gradeItem.get("title") as String + " " + (gradeItem.get("step") as Double).toInt()
                binding.ivVip.visibility = View.GONE
            }
        }
    }

    interface ItemOnClickListener {
        fun onClick(view: View, position: Int)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HashMap<String, Any>>() {
            override fun areItemsTheSame(
                oldItem: HashMap<String, Any>,
                newItem: HashMap<String, Any>
            ): Boolean {
                return oldItem.get("id") as String == newItem.get("id") as String
            }

            override fun areContentsTheSame(
                oldItem: HashMap<String, Any>,
                newItem: HashMap<String, Any>
            ): Boolean {
                return oldItem.get("id") as String == newItem.get("id") as String
            }

        }
    }
}
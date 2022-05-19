package com.ssafy.smartstore.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.smartstore.databinding.RvCommentBinding
import com.ssafy.smartstore.remote.dto.Comment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
private const val TAG = "CommentAdapter___"
class CommentAdapter(val user_id: String) :
    ListAdapter<Comment, CommentAdapter.ItemViewHolder>(diffUtil) {

    lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentAdapter.ItemViewHolder = ItemViewHolder(
        RvCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CommentAdapter.ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ItemViewHolder(private val binding: RvCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) {
            binding.tvComment.text = comment.comment
            if (user_id != comment.userId) {
                binding.btnUpdateComment.visibility = View.GONE
                binding.btnDeleteComment.visibility = View.GONE
            }


            binding.btnUpdateComment.setOnClickListener {
                onItemClickListener.onUpdate(comment, adapterPosition)
            }

            binding.btnDeleteComment.setOnClickListener {
                onItemClickListener.onDelete(comment, adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onUpdate(comment: Comment, position: Int)
        fun onDelete(comment: Comment, position: Int)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }
}
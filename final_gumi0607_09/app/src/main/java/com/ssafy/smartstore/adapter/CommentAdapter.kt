package com.ssafy.smartstore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.smartstore.databinding.RvCommentBinding
import com.ssafy.smartstore.data.remote.dto.Comment

private const val TAG = "CommentAdapter___"

class CommentAdapter(val user_id: String, var state: Boolean = false) :
    ListAdapter<Comment, CommentAdapter.ItemViewHolder>(diffUtil) {

    lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentAdapter.ItemViewHolder = ItemViewHolder(
        RvCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CommentAdapter.ItemViewHolder, position: Int) {
        if (!state) holder.bind(currentList[position])
        else holder.bindUser(currentList[position])
    }

    inner class ItemViewHolder(private val binding: RvCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) {
            binding.tvComment.text = comment.comment

            if (!state) {
                binding.tvId.visibility = View.GONE
                binding.ratingBar.visibility = View.GONE
            }

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

        fun bindUser(comment: Comment) {
            bind(comment)
            binding.tvId.text = comment.userId
            binding.ratingBar.rating = comment.rating / 2
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
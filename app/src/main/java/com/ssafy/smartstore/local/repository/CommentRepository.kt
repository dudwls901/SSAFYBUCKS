package com.ssafy.smartstore.local.repository

import android.content.Context
import android.util.Log
import com.ssafy.smartstore.local.database.StoreDatabase
import com.ssafy.smartstore.local.dto.Comment

private const val TAG = " CommentRepository_sss"
class CommentRepository(context: Context) {
    private val db = StoreDatabase.getInstance(context)!!

    private val cDao = db.commentDao()

    suspend fun addComment(comment: Comment) {
        cDao.insert(comment)
    }

    suspend fun selectComment(id: Int): Comment {
        return cDao.select(id)
    }

    suspend fun removeComment(id: Int) {
        cDao.delete(id)
    }

    suspend fun updateComment(comment: Comment) {
        Log.d(TAG, "updateComment: $comment")
        cDao.update(comment)
    }

    suspend fun selectByProduct(productId: Int): List<Comment> {
        return cDao.selectByProduct(productId)
    }

    suspend fun insert(comment: Comment): Long = db.commentDao().insert(comment)

    suspend fun update(comment: Comment): Int = db.commentDao().update(comment)

    suspend fun delete(commentId: Int): Int = db.commentDao().delete(commentId)

    suspend fun select(commentId: Int): Comment = db.commentDao().select(commentId)

    suspend fun selectAll(): List<Comment> = db.commentDao().selectAll()


    companion object{
        private var INSTANCE: CommentRepository? = null

        fun getInstance(context: Context): CommentRepository{
            if(INSTANCE==null){
                INSTANCE = CommentRepository(context)
            }
            return  INSTANCE?: throw IllegalStateException("초기화해주세용.")
        }

    }

}
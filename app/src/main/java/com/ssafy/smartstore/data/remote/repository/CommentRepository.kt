package com.ssafy.smartstore.data.remote.repository

import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.data.remote.dto.Comment
import retrofit2.Response

class CommentRepository {

    companion object {
        val INSTANCE = CommentRepository()
    }

    // 제품에 해당하는 코멘트 리스트 가져옴
    suspend fun searchComments(id: Int): Response<List<Comment>> {
        return RetrofitClient.commentService.searchComments(id)
    }

    // 새로운 코멘트를 등록한다
    suspend fun insertComment(comment: Comment): Response<List<Comment>> {
        return RetrofitClient.commentService.insertComment(comment)
    }

    // 코멘트를 수정한다
    suspend fun updateComment(comment: Comment): Response<List<Comment>> {
        return RetrofitClient.commentService.updateComment(comment)
    }

    // 코멘트를 삭제한다
    suspend fun deleteComment(id: Int): Response<List<Comment>> {
        return RetrofitClient.commentService.deleteComment(id)
    }

}
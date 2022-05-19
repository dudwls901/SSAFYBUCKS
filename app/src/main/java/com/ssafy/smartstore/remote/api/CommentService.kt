package com.ssafy.smartstore.remote.api

import com.ssafy.smartstore.local.dto.User
import com.ssafy.smartstore.remote.dto.Comment
import com.ssafy.smartstore.util.Constants
import retrofit2.Response
import retrofit2.http.*

interface CommentService {

    // 제품에 해당하는 코멘트 리스트 가져옴
    @GET("${Constants.COMMENT}/{id}")
    suspend fun searchComments(@Path("id") id: Int) : Response<List<Comment>>

    // 새로운 코멘트를 등록한다
    @POST("${Constants.COMMENT}")
    suspend fun insertComment(@Body comment: Comment) : Response<List<Comment>>

    // 코멘트를 수정한다
    @PUT("${Constants.COMMENT}")
    suspend fun updateComment(@Body comment: Comment) : Response<List<Comment>>

    // 코멘트를 삭제한다
    @DELETE("${Constants.COMMENT}/{id}")
    suspend fun deleteComment(@Path("id") id: Int) : Response<List<Comment>>
}
package com.ssafy.smartstore.data.remote.api

import com.ssafy.smartstore.data.remote.dto.Comment
import com.ssafy.smartstore.util.Network.COMMENT
import retrofit2.Response
import retrofit2.http.*

interface CommentService {

    // 제품에 해당하는 코멘트 리스트 가져옴
    @GET("${COMMENT}/{id}")
    suspend fun searchComments(@Path("id") id: Int) : Response<List<Comment>>

    // 새로운 코멘트를 등록한다
    @POST("${COMMENT}")
    suspend fun insertComment(@Body comment: Comment) : Response<List<Comment>>

    // 코멘트를 수정한다
    @PUT("${COMMENT}")
    suspend fun updateComment(@Body comment: Comment) : Response<List<Comment>>

    // 코멘트를 삭제한다
    @DELETE("${COMMENT}/{id}")
    suspend fun deleteComment(@Path("id") id: Int) : Response<List<Comment>>
}
package com.ssafy.smartstore.data.remote.api

import com.ssafy.smartstore.util.Network.SEND_MESSAGE_TO
import com.ssafy.smartstore.util.Network.TOKEN
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface TokenService {

    // Token 정보 서버로 전송
    @POST(TOKEN)
    suspend fun uploadToken(
        @Query("userId") userId: String,
        @Query("token") token: String
    ): Response<String>

    // Token 정보 서버로 전송
    @POST(TOKEN+SEND_MESSAGE_TO)
    suspend fun sendMessageTo(
        @Query("userId") userId: String,
        @Query("body") body: String,
        @Query("title") title: String
    ): Response<String>

}
package com.ssafy.smartstore.remote.api

import com.ssafy.smartstore.util.Constants.TOKEN
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
}
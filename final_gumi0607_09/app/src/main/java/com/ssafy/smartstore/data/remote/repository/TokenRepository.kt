package com.ssafy.smartstore.data.remote.repository

import com.ssafy.smartstore.data.remote.RetrofitClient
import retrofit2.Response

class TokenRepository {

    companion object {
        val INSTANCE = TokenRepository()
    }

    // Token 정보 서버로 전송
    suspend fun uploadToken(userId: String, token: String): Response<String> {
        return RetrofitClient.tokenService.uploadToken(userId, token);
    }
}
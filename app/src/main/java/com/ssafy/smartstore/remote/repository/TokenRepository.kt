package com.ssafy.smartstore.remote.repository

import android.util.Log
import com.ssafy.smartstore.remote.RetrofitClient
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
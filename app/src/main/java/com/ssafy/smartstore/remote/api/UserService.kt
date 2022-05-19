package com.ssafy.smartstore.remote.api

import com.ssafy.smartstore.local.dto.Product
import com.ssafy.smartstore.local.dto.User
import com.ssafy.smartstore.util.Constants
import com.ssafy.smartstore.util.Constants.USER
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    // 사용자 정보를 추가한다
    @POST(USER)
    suspend fun insert(@Body user: User): Response<Int>

    // request parameter로 전달된 id가 이미 사용중인지 반환한다
    @GET("$USER/{id}")
    suspend fun isUsedId(@Path("id") id: String): Response<Boolean>

    // 로그인 처리 후 성공적으로 로그인 되었다면 loginId라는 쿠키를 내려보낸다
    @POST("$USER/login")
    suspend fun login(@Body user: User): Response<User>

    // 사용자의 정보와 함께 사용자의 주문 내역, 사용자 등급 정보를 반환한다
    @POST("$USER/info")
    suspend fun getInfo(@Query("id") id: String): Response<Map<String, Any>>

}
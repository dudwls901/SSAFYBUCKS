package com.ssafy.smartstore.data.remote.repository

import android.util.Log
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.User
import com.ssafy.smartstore.data.remote.RetrofitClient
import retrofit2.Response

private const val TAG = "UserRepository_"

class UserRepository {

    companion object{
        val INSTANCE = UserRepository()
    }

    // 사용자 정보를 추가한다
    suspend fun insert(user: User): Response<Int> {
        return RetrofitClient.userService.insert(user)
    }

    // request parameter로 전달된 id가 이미 사용중인지 반환한다
    suspend fun isUsedId(id: String): Response<Boolean> {
        Log.d(TAG, "isUsedId: $id")
        return RetrofitClient.userService.isUsedId(id)
    }

    // 로그인 처리 후 성공적으로 로그인 되었다면 loginId라는 쿠키를 내려보낸다
    suspend fun login(user: User): Response<User> {
        Log.d(TAG, "login: $user")
        return RetrofitClient.userService.login(user)
    }

    // 사용자의 정보와 함께 사용자의 주문 내역, 사용자 등급 정보를 반환한다
    suspend fun getInfo(id: String): Response<Map<String,Any>> {
        return RetrofitClient.userService.getInfo(id)
    }

    // 모든 유저의 스탬프 등급 반환
    suspend fun getInfos(): Response<List<HashMap<String, Any>>> {
        return RetrofitClient.userService.getInfos()
    }
}
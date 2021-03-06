package com.ssafy.smartstore.data.remote.api

import com.ssafy.smartstore.data.remote.dto.Order
import com.ssafy.smartstore.data.remote.dto.OrderInfoResponse
import com.ssafy.smartstore.util.Network.GET_ORDER_MONTH
import com.ssafy.smartstore.util.Network.ORDER
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OrderService {

    @GET(GET_ORDER_MONTH)
    suspend fun getOrderMonth(@Query("id") id: String): Response<List<OrderInfoResponse>>

    @POST(ORDER)
    suspend fun makeOrder(@Body map: HashMap<String, Any>): Response<Int>

//    @GET("${GET_PRODUCT}/{productId}")
//    suspend fun getProduct(@Path("productId") productId: Int): Response<List<MutableMap<String,Any>>>

}
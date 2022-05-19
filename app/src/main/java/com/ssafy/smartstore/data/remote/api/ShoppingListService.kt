package com.ssafy.smartstore.data.remote.api

import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.Network
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ShoppingListService {

    @POST("${Network.SHOPPING_LIST}/add")
    suspend fun addShoppingList(@Body map: HashMap<String, Any>): Response<List<OrderProduct>>

    @GET("${Network.SHOPPING_LIST}/{userId}")
    suspend fun selectByUser(@Path("userId") userId: String): Response<List<OrderProduct>>
}
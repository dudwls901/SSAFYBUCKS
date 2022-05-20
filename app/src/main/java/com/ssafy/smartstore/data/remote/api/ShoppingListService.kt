package com.ssafy.smartstore.data.remote.api

import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.Network
import retrofit2.Response
import retrofit2.http.*

interface ShoppingListService {

    @POST("${Network.SHOPPING_LIST}/add")
    suspend fun addShoppingList(@Body map: HashMap<String, Any>): Response<List<OrderProduct>>

    @GET("${Network.SHOPPING_LIST}/{userId}")
    suspend fun selectByUser(@Path("userId") userId: String): Response<List<OrderProduct>>

    @POST("${Network.SHOPPING_LIST}/delete")
    suspend fun deleteOneItem(@Body map: HashMap<String, Any>): Response<List<OrderProduct>>

    @DELETE("${Network.SHOPPING_LIST}/{userId}")
    suspend fun deleteByUser(@Path("userId") userId: String): Response<List<OrderProduct>>

}
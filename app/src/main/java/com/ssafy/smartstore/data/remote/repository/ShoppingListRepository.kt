package com.ssafy.smartstore.data.remote.repository

import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.model.OrderProduct
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Path

class ShoppingListRepository {

    companion object {
        val INSTANCE = ShoppingListRepository()
    }

    suspend fun addShoppingList(map: HashMap<String, Any>): Response<List<OrderProduct>> {
        return RetrofitClient.shoppingListService.addShoppingList(map)
    }

    suspend fun selectByUser(userId: String): Response<List<OrderProduct>> {
        return RetrofitClient.shoppingListService.selectByUser(userId)
    }

    suspend fun deleteOneItem(map: HashMap<String, Any>): Response<List<OrderProduct>> {
        return RetrofitClient.shoppingListService.deleteOneItem(map)
    }


    suspend fun deleteByUser(userId: String): Response<List<OrderProduct>> {
        return RetrofitClient.shoppingListService.deleteByUser(userId)
    }
}
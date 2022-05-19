package com.ssafy.smartstore.remote.repository

import com.ssafy.smartstore.remote.RetrofitClient
import com.ssafy.smartstore.remote.dto.Order
import com.ssafy.smartstore.remote.dto.OrderInfoResponse
import retrofit2.Response

class OrderRepository {

    companion object{
        val INSTANCE = OrderRepository()
    }

    suspend fun getOrderMonth(id: String): Response<List<OrderInfoResponse>> {
        return RetrofitClient.orderService.getOrderMonth(id)
    }

    suspend fun makeOrder(order: Order): Response<Int> {
        return RetrofitClient.orderService.makeOrder(order)
    }

//    suspend fun getProduct(productId: Int): Response<List<MutableMap<String,Any>>> {
//        Log.d("repository", "getProduct: $productId")
//        return RetrofitClient.productService.getProduct(productId)
//    }

}
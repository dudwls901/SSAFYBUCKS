package com.ssafy.smartstore.data.remote.repository

import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.data.remote.dto.Order
import com.ssafy.smartstore.data.remote.dto.OrderInfoResponse
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
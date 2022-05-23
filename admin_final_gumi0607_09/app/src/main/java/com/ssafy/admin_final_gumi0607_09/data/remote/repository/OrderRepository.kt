package com.ssafy.smartstore.data.remote.repository

import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.data.remote.dto.Order
import com.ssafy.smartstore.data.remote.dto.OrderDetail
import com.ssafy.smartstore.data.remote.dto.OrderInfoResponse
import retrofit2.Response

class OrderRepository {

    companion object {
        val INSTANCE = OrderRepository()
    }

    suspend fun getOrderMonth(id: String): Response<List<OrderInfoResponse>> {
        return RetrofitClient.orderService.getOrderMonth(id)
    }

    suspend fun getOrderDay(date: String): Response<List<OrderInfoResponse>> {
        return RetrofitClient.orderService.getOrderDay(date)
    }

    suspend fun makeOrder(map: HashMap<String, Any>): Response<Int> {
        return RetrofitClient.orderService.makeOrder(map)
    }

    suspend fun getAllOrderDetail(): Response<List<OrderDetail>> {
        return RetrofitClient.orderService.getAllOrderDetail()
    }

    suspend fun changeOrderComplete(orderId: Int): Response<String>{
        return RetrofitClient.orderService.changeOrderComplete(orderId)
    }

//    suspend fun getProduct(productId: Int): Response<List<MutableMap<String,Any>>> {
//        Log.d("repository", "getProduct: $productId")
//        return RetrofitClient.productService.getProduct(productId)
//    }

}
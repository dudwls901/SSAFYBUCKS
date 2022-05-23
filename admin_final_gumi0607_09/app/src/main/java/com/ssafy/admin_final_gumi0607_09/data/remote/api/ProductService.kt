package com.ssafy.admin_final_gumi0607_09.data.remote.api

import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.smartstore.data.remote.dto.OrderDetail
import com.ssafy.smartstore.util.Network.GET_PRODUCT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET(GET_PRODUCT)
    suspend fun getProductList() : Response<List<Product>>

    @GET("${GET_PRODUCT}/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int): Response<Product>


}
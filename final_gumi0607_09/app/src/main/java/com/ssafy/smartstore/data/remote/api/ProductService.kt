package com.ssafy.smartstore.data.remote.api

import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.util.Network.GET_PRODUCT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

//http://localhost:9999/rest/product

    @GET(GET_PRODUCT)
    suspend fun getProductList() : Response<List<Product>>

    @GET("${GET_PRODUCT}/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int): Response<Product>

}
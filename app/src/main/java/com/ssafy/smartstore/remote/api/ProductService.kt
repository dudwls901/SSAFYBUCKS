package com.ssafy.smartstore.remote.api

import com.ssafy.smartstore.local.dto.Product
import com.ssafy.smartstore.util.Constants.GET_PRODUCT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

//http://localhost:9999/rest/product

    @GET(GET_PRODUCT)
    suspend fun getProductList() : Response<List<Product>>

    @GET("${GET_PRODUCT}/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int): Response<Product>

}
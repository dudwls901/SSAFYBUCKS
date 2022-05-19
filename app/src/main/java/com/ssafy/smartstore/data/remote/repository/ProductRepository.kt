package com.ssafy.smartstore.data.remote.repository

import android.util.Log
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.data.remote.RetrofitClient
import retrofit2.Response

class ProductRepository {

    companion object{
        val INSTANCE = ProductRepository()
    }

    suspend fun getProductList(): Response<List<Product>> {
        return RetrofitClient.productService.getProductList()
    }

    suspend fun getProduct(productId: Int): Response<Product> {
        Log.d("repository", "getProduct: $productId")
        return RetrofitClient.productService.getProduct(productId)
    }

}
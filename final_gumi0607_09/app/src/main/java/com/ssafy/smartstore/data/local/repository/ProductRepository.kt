package com.ssafy.smartstore.data.local.repository

import android.content.Context
import com.ssafy.smartstore.data.local.database.StoreDatabase
import com.ssafy.smartstore.data.local.dto.Product


private const val TAG = " ProductRepository_sss"
class ProductRepository() {
    private val db = StoreDatabase.getInstance()!!

    private val pDao = db.productDao()

    suspend fun getProductList(): List<Product> {
        return pDao.selectAll()
    }

    suspend fun select(productId: Int): Product {
        return pDao.select(productId)
    }

    suspend fun insert(product: Product): Long = db.productDao().insert(product)

    suspend fun update(product: Product): Int = db.productDao().update(product)

    suspend fun delete(productId: Int): Int = db.productDao().delete(productId)

    companion object{
        private var INSTANCE: ProductRepository? = null

        fun getInstance(): ProductRepository{
            if(INSTANCE==null){
                INSTANCE = ProductRepository()
            }
            return  INSTANCE?: throw IllegalStateException("초기화해주세용.")
        }

    }

}
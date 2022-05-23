package com.ssafy.smartstore.data.local.repository

import android.content.Context
import com.ssafy.smartstore.data.local.database.StoreDatabase
import com.ssafy.smartstore.data.local.dto.OrderDetail
import java.lang.IllegalStateException

private const val TAG = " OrderDetailRepository_sss"
class OrderDetailRepository() {
    private val db = StoreDatabase.getInstance()!!

    suspend fun insert(detail: OrderDetail): Long = db.orderDetailDao().insert(detail)

    suspend fun delete(detailId: Int): Int = db.orderDetailDao().delete(detailId)

    suspend fun select(detailId: Int): OrderDetail = db.orderDetailDao().select(detailId)

    suspend fun selectAll(): List<OrderDetail> = db.orderDetailDao().selectAll()

    suspend fun selectByProductId(productId: Int): List<OrderDetail> = db.orderDetailDao().selectByProductId(productId)

    suspend fun selectByOrderId(orderId: Int): List<OrderDetail> = db.orderDetailDao().selectByOrderId(orderId)

    companion object{
        private var INSTANCE: OrderDetailRepository? = null

        fun getInstance(): OrderDetailRepository{
            if(INSTANCE==null){
                INSTANCE = OrderDetailRepository()
            }
            return  INSTANCE?: throw IllegalStateException("초기화해주세용.")
        }

    }

}
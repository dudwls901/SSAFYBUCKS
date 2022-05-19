package com.ssafy.smartstore.local.repository

import android.content.Context
import android.util.Log
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ssafy.smartstore.local.database.StoreDatabase
import com.ssafy.smartstore.local.dto.OrderDetail
import com.ssafy.smartstore.local.dto.User
import java.lang.IllegalStateException

private const val TAG = " OrderDetailRepository_sss"
class OrderDetailRepository(context: Context) {
    private val db = StoreDatabase.getInstance(context)!!

    suspend fun insert(detail: OrderDetail): Long = db.orderDetailDao().insert(detail)

    suspend fun delete(detailId: Int): Int = db.orderDetailDao().delete(detailId)

    suspend fun select(detailId: Int): OrderDetail = db.orderDetailDao().select(detailId)

    suspend fun selectAll(): List<OrderDetail> = db.orderDetailDao().selectAll()

    suspend fun selectByProductId(productId: Int): List<OrderDetail> = db.orderDetailDao().selectByProductId(productId)

    suspend fun selectByOrderId(orderId: Int): List<OrderDetail> = db.orderDetailDao().selectByOrderId(orderId)

    companion object{
        private var INSTANCE: OrderDetailRepository? = null

        fun getInstance(context: Context): OrderDetailRepository{
            if(INSTANCE==null){
                INSTANCE = OrderDetailRepository(context)
            }
            return  INSTANCE?: throw IllegalStateException("초기화해주세용.")
        }

    }

}
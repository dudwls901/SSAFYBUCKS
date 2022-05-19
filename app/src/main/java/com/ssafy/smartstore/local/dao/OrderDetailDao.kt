package com.ssafy.smartstore.local.dao

import androidx.room.*
import com.ssafy.smartstore.local.dto.OrderDetail

@Dao
interface OrderDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(detail: OrderDetail): Long

    @Query("DELETE FROM t_order_detail WHERE d_id = :detailId")
    suspend fun delete(detailId: Int): Int

    @Query("SELECT * FROM t_order_detail WHERE d_id = :detailId")
    suspend fun select(detailId: Int): OrderDetail

    @Query("SELECT * FROM t_order_detail")
    suspend fun selectAll(): List<OrderDetail>

    @Query("SELECT * FROM t_order_detail WHERE product_id= :productId")
    suspend fun selectByProductId(productId: Int): List<OrderDetail>

    @Query("SELECT * FROM t_order_detail WHERE order_id= :orderId")
    suspend fun selectByOrderId(orderId: Int): List<OrderDetail>

}
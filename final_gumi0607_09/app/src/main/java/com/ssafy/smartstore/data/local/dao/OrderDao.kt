package com.ssafy.smartstore.data.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ssafy.smartstore.data.local.dto.Order

@Dao
interface OrderDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(order: Order): Long

    @Update
    suspend fun update(order: Order): Int

    @Query("DELETE FROM t_order WHERE o_id = :orderId")
    suspend fun delete(orderId: Int): Int

    @Query("SELECT * FROM t_order WHERE o_id = :orderId")
    suspend fun select(orderId: Int): Order

    @Query("SELECT * FROM t_order")
    suspend fun selectAll(): List<Order>

    @Query("SELECT * FROM t_order WHERE o_id = " +
            "(SELECT o_id FROM t_order_detail WHERE d_id = :id )")
    suspend fun selectWithDetail(id: Int): Order

    @Query("select * from t_order WHERE user_id " +
            "= :userId ORDER BY order_time desc")
    suspend fun selectByUser(userId: String?): List<Order>
}
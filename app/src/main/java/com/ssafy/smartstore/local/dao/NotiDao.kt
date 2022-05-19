package com.ssafy.smartstore.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ssafy.smartstore.local.dto.Noti
import com.ssafy.smartstore.local.dto.User


@Dao
interface NotiDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(noti: Noti): Long

    @Query("SELECT * FROM t_noti WHERE u_id = :id ")
    suspend fun select(id: String): List<Noti>

    @Query("DELETE FROM t_noti WHERE id = :id")
    suspend fun delete(id: Int): Int

}
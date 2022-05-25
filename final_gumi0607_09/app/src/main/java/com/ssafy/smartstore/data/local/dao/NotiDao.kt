package com.ssafy.smartstore.data.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ssafy.smartstore.data.local.dto.Noti


@Dao
interface NotiDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(noti: Noti): Long

    @Query("SELECT * FROM t_noti WHERE u_id = :id ORDER BY id DESC")
    suspend fun select(id: String): List<Noti>

    @Query("DELETE FROM t_noti WHERE id = :id")
    suspend fun delete(id: Int): Int

}
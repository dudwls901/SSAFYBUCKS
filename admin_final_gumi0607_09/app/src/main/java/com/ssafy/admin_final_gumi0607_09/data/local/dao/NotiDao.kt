package com.ssafy.admin_final_gumi0607_09.data.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ssafy.admin_final_gumi0607_09.data.local.entity.Noti


@Dao
interface NotiDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(noti: Noti): Long

    @Query("SELECT * FROM t_noti")
    suspend fun select(): List<Noti>

//    @Query("DELETE FROM t_noti WHERE id = :id")
//    suspend fun delete(id: Int): Int

}
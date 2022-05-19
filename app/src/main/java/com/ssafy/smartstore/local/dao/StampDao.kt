package com.ssafy.smartstore.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.ssafy.smartstore.local.dto.Stamp

@Dao
interface StampDao {

   @Insert(onConflict = REPLACE)
   suspend fun insert(stamp: Stamp): Long

   @Query("SELECT * FROM t_stamp WHERE id =:stampId")
   suspend fun select(stampId: Int): Stamp

   @Query("SELECT * FROM t_stamp")
   suspend fun selectAll(): List<Stamp>

   @Query("SELECT * FROM t_stamp WHERE id = :userId ORDER BY id desc")
   suspend fun selectByUserId(userId: String): List<Stamp>


}
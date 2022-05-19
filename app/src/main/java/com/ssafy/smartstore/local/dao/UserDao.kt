package com.ssafy.smartstore.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ssafy.smartstore.local.dto.User


@Dao
interface UserDao {

    @Query("SELECT * FROM t_user")
    suspend fun selectAll():List<User>

    @Query("SELECT * FROM t_user WHERE id = :id ")
    suspend fun select(id: String): User

    @Insert(onConflict = REPLACE)
    suspend fun insert(user: User): Long

    @Query("update t_user set stamps = (select sum(quantity) from t_stamp where user_id = :id) where id = :id")
    suspend fun updateStamp(id: String): Int

    @Query("DELETE FROM t_user WHERE id = :userId")
    suspend fun delete(userId: String): Int

    @Update
    suspend fun update(user: User): Int

}
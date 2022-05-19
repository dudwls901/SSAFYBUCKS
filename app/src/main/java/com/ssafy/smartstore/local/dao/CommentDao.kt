package com.ssafy.smartstore.local.dao

import androidx.room.*
import com.ssafy.smartstore.local.dto.Comment

@Dao
interface CommentDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(comment: Comment): Long

   @Update
   suspend fun update(comment: Comment): Int

   @Query("DELETE FROM t_comment WHERE id = :commentId")
   suspend fun delete(commentId: Int): Int

   @Query("SELECT * FROM t_comment WHERE id = :commentId")
   suspend fun select(commentId: Int): Comment

   @Query("SELECT * FROM t_comment")
   suspend fun selectAll(): List<Comment>

   @Query("SELECT * FROM t_comment WHERE product_id " +
           "= :productId ORDER BY id desc")
   suspend fun selectByProduct(productId: Int): List<Comment>

}
package com.ssafy.smartstore.local.dao

import androidx.room.*
import com.ssafy.smartstore.local.dto.Product

@Dao
interface ProductDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(product: Product): Long

   @Update
   suspend fun update(product: Product): Int

   @Query("DELETE FROM t_product WHERE id =:productId")
   suspend fun delete(productId: Int): Int

   @Query("SELECT * FROM t_product WHERE id =:productId")
   suspend fun select(productId: Int): Product

   @Query("SELECT * FROM t_product")
   suspend fun selectAll(): List<Product>

}
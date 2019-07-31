package com.rizkyfadilah.sehatq.data.source.db

import androidx.room.*
import com.rizkyfadilah.sehatq.domain.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product): Long

    @Query("SELECT * from Product")
    suspend fun selectAllProduct(): MutableList<Product>

}
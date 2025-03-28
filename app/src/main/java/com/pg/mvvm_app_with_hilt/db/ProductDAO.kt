package com.pg.mvvm_app_with_hilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pg.mvvmwithdagger2example.models.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(productList: List<Product>)

    @Query("SELECT * FROM product")
    suspend fun getProductList(): List<Product>
}
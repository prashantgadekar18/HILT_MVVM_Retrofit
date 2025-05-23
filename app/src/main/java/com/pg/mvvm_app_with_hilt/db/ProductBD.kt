package com.pg.mvvm_app_with_hilt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pg.mvvm_app_with_hilt.utils.Constants
import com.pg.mvvmwithdagger2example.models.Product

@Database(entities = [Product::class],  version = 1)
abstract class ProductBD : RoomDatabase() {
    abstract fun getProductDAO() : ProductDAO
}
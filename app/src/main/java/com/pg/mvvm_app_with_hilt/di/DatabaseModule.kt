package com.pg.mvvm_app_with_hilt.di

import android.content.Context
import androidx.room.Room
import com.pg.mvvm_app_with_hilt.db.ProductDB
import com.pg.mvvm_app_with_hilt.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getRoomDatabase(@ApplicationContext context: Context) : ProductDB{
        return Room.databaseBuilder(context, ProductDB::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}
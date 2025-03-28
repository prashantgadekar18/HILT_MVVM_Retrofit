package com.pg.mvvm_app_with_hilt.di

import com.pg.mvvm_app_with_hilt.retrofit.ProductAPI
import com.pg.mvvm_app_with_hilt.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit () : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideProductAPIs(retrofit: Retrofit): ProductAPI{
        return retrofit.create(ProductAPI::class.java)
    }
}
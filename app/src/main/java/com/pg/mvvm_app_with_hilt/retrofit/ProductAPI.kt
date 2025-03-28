package com.pg.mvvm_app_with_hilt.retrofit

import com.pg.mvvmwithdagger2example.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    suspend fun getProductList(): Response<List<Product>>
}
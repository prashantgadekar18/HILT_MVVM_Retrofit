package com.pg.mvvm_app_with_hilt.reposiotory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pg.mvvm_app_with_hilt.retrofit.ProductAPI
import com.pg.mvvmwithdagger2example.models.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productAPI: ProductAPI,
                                           ) {
//                                            private val productDB: ProductBD) {

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
        get() = _products

    suspend fun getProducts(){
        val result = productAPI.getProductList()
        if (result.isSuccessful && result.body() != null){
//            productDB.getProductDAO().saveProducts(result.body()!!)
            _products.postValue(result.body())
            _products.postValue(result.body())
        }
    }
}
package com.pg.mvvm_app_with_hilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pg.mvvm_app_with_hilt.reposiotory.ProductRepository
import com.pg.mvvmwithdagger2example.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel2 @Inject constructor(private val productRepository: ProductRepository): ViewModel() {

    val productsLiveData : LiveData<List<Product>>
        get() = productRepository.products

    init {

        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}
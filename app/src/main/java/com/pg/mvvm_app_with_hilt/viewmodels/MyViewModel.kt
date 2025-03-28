package com.pg.mvvm_app_with_hilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pg.mvvmwithdagger2example.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {

    private val _productList : LiveData<List<Product>> = MutableLiveData()

    val productListLiveData : LiveData<List<Product>>
        get() = _productList



}
package com.pg.mvvm_app_with_hilt

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pg.mvvm_app_with_hilt.adapter.ProductListAdapter
import com.pg.mvvm_app_with_hilt.viewmodels.MainViewModel
import com.pg.mvvm_app_with_hilt.viewmodels.MainViewModel2
import com.pg.mvvm_app_with_hilt.viewmodels.MyViewModel
import com.pg.mvvmwithdagger2example.models.Product
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    @Inject
    lateinit var mainViewModel: MainViewModel2

    lateinit var myViewModel: MyViewModel


    val rvProductList : RecyclerView
        get() = findViewById(R.id.rvProductList)


//    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        mainViewModel = ViewModelProvider(this)[MainViewModel2::class.java]
        mainViewModel.productsLiveData.observe(this, Observer {
            setRecyclerView(it)

        })


        myViewModel.productListLiveData.observe(this, Observer {
            Log.d("Creator", "productListLiveData")
        })
    }

    private fun setRecyclerView(productList: List<Product>?) {
        val productAdapter = ProductListAdapter(productList !!)
        rvProductList.layoutManager = LinearLayoutManager(this)
        rvProductList.adapter = productAdapter

    }
}
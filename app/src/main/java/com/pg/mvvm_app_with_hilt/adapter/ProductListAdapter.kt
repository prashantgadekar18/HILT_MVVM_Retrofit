package com.pg.mvvm_app_with_hilt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pg.mvvm_app_with_hilt.R
import com.pg.mvvmwithdagger2example.models.Product
import dagger.hilt.android.AndroidEntryPoint

class ProductListAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ProductViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ProductViewHolder, position: Int) {
        holder.tvProductName.text = productList[position].title
        holder.tvProductPrice.text = holder.itemView.context.resources.getString(R.string.product_price) + productList[position].price.toString()

        Glide.with(holder.itemView.context)
            .load(productList[position].image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(holder.ivProduct)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvProductName : TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice : TextView = itemView.findViewById(R.id.tvProductPrice)
        val ivProduct : ImageView = itemView.findViewById(R.id.ivProduct)

    }
}
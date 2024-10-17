package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shital.myapplication.R
import com.shital.myapplication.designs.Hilt.adapter.PostAdapterHilt
import com.shital.myapplication.designs.Hilt.model.PostHilt
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.model.productsItem
import dagger.hilt.android.qualifiers.ApplicationContext

class ProductsAdapter  (val list: List<productsItem>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id = view.findViewById<TextView>(R.id.id)
        val title = view.findViewById<TextView>(R.id.title)
        val price = view.findViewById<TextView>(R.id.price)
        val description = view.findViewById<TextView>(R.id.description)
        val category = view.findViewById<TextView>(R.id.category)
        val image = view.findViewById<ImageView>(R.id.image)

        // val id = view.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsAdapter.MyViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.title.text = list[position].title
        holder.price.text = list[position].price.toString()
        holder.description.text = list[position].description
        holder.category.text = list[position].category

        Glide.with(holder.itemView.context).load(list[position].image).into(holder.image)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
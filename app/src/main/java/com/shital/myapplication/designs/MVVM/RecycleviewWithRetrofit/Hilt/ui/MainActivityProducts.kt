package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.Hilt.ViewModel.PostViewModelHilt
import com.shital.myapplication.designs.Hilt.adapter.PostAdapterHilt
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.adapter.ProductsAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.viewModel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivityProducts : AppCompatActivity() {


    private lateinit var productsAdapter: ProductsAdapter
    lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.layoutManager = LinearLayoutManager(this@MainActivityProducts)


        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        productsViewModel.getProducts()
        productsViewModel.productsList.observe(this, Observer {

            productsAdapter = ProductsAdapter(it)
            recyclerView.adapter = productsAdapter

            Log.d("main", it.toString())
        })


    }
}
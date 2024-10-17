package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.Repository

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.network.RetrofitBuilderAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.model.productsItem
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.network.ProductsApiService
import retrofit2.Response
import javax.inject.Inject


class ProductsRepository @Inject constructor(private val productsApiService: ProductsApiService){

    suspend fun getProducts(): Response<List<productsItem>> = productsApiService.getProducts()
}
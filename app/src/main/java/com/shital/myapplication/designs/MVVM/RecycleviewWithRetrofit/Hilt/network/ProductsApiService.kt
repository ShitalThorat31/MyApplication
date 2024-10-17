package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.network

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.model.productsItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApiService {

    @GET("products")
    suspend fun getProducts() : Response<List<productsItem>>
}
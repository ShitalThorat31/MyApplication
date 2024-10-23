package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.Hilt.Repository

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.Hilt.model.productsItem
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.Hilt.network.ProductsApiService
import retrofit2.Response
import javax.inject.Inject


class ProductsRepository @Inject constructor(private val productsApiService: ProductsApiService){

    suspend fun getProducts(): Response<List<productsItem>> = productsApiService.getProducts()
}
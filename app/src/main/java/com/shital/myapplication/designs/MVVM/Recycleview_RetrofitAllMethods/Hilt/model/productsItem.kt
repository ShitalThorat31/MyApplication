package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.Hilt.model

data class productsItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)
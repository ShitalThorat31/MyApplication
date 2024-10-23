package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_enqueue



class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}
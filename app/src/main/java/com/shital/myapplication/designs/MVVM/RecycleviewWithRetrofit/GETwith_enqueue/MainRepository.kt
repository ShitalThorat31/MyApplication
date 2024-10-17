package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_enqueue



class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}
package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilderAnimals {
    companion object{
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()

                //.baseUrl(url.base_url)
                .baseUrl(url.base_url_comments)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: InterfaceApi by lazy {
            retrofit.create(InterfaceApi::class.java)
        }
    }
}
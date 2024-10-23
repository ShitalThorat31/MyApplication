package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                //.baseUrl(Url.url)
                .baseUrl(Url.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}
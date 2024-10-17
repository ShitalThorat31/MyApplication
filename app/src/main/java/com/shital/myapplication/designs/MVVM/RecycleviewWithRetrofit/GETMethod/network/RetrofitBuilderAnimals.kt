package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.network

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Network.Api
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Network.Url
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
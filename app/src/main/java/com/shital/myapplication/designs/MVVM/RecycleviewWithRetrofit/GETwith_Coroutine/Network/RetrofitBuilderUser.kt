package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilderUser {
    companion object{
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
               .baseUrl(Url.User_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}
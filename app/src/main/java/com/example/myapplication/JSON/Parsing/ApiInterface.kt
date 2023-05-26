package com.example.myapplication.JSON.Parsing

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getData():Call<List<MyDataItem>>
}
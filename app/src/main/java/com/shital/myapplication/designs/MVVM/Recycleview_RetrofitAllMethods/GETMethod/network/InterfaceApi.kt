package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.network

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceApi {

    @GET("/api/v1/animals")
    suspend fun getAllAnimals(): Response<List<animalsItem>>


    //https://freetestapi.com/api/v1/animals/1

    @GET("/api/v1/animals/{id}")
    suspend fun getSingleAnimal(@Path("id")id:Int): Response<animalsItem>


    @GET("/comments")
    suspend fun getCommentspostId(@Query("postId")postId:Int): Response<List<Post>>

}
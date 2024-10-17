package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Network

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.Post
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface Api
{
   // @GET("posts")
    //@GET("posts/1/comments")
    //suspend fun getAllPost(): List<Post>

    @GET("comments")
    suspend fun getAllPost(@Query("postId")postId:Int): List<Post>

    @GET("/api/users")
    suspend fun getAllUser(): List<User>


    @GET("/api/users")
    suspend fun getAllUser(@Query("search")search:String): List<User>

}
package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Repository

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Model.Post
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Network.RetrofitBuilder

class PostRepository {

    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getAllPost(1)

}
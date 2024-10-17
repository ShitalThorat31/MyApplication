package com.shital.myapplication.designs.Hilt.Network

import com.shital.myapplication.designs.Hilt.model.PostHilt
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceHilt {

    @GET("posts")
    suspend fun getPosts() : Response<List<PostHilt>>

}
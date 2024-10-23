package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Network

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Model.PostModel
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Model.PostmodelItem
import retrofit2.Response
import retrofit2.http.*

interface Api
{



   @FormUrlEncoded
    @POST("/api/users/create")
    suspend fun createUser(@Field("fname")fname:String,@Field("lname")lname:String,
       @Field("username")username:String,@Field("password")password:String,
       @Field("email")email:String,@Field("avatar")avatar:String,

   ): Response<PostModel>

    @POST("/api/users/")
    suspend fun postToServer(@Body post: PostmodelItem): Response<PostmodelItem>


    @PUT("/api/users/{id}")
    suspend fun putRequest(@Path("id") id: Int, @Body postmodelItem: PostmodelItem): Response<PostmodelItem>

    @PUT("/api/users/{id}")
    suspend fun patchRequest(@Path("id") id: Int, @Body postmodelItem: PostmodelItem): Response<PostmodelItem>

    @DELETE("api/users/{id}")
    suspend fun deletePost(@Path("id")id:Int):Response<Unit>

}
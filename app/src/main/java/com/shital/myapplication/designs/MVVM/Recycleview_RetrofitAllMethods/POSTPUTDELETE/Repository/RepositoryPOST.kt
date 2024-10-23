package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Repository

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Model.PostModel
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Model.PostmodelItem
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Network.RetrofitBuilderPOST
import retrofit2.Response

class RepositoryPOST {

    suspend fun getPost(): Response<PostModel> = RetrofitBuilderPOST.api.createUser("shital","thorat","cat.chat@melivecode.com","1234","cat.chat@melivecode.com","https://www.melivecode.com/users/cat.png")


    suspend fun postToServer():Response<PostmodelItem> = RetrofitBuilderPOST.api.postToServer(post = PostmodelItem( "this is shital",111,"ssss",112))
    suspend fun putRequest():Response<PostmodelItem> = RetrofitBuilderPOST.api.putRequest(1,  PostmodelItem("this is NINAD",111,"PUT REQUEST",113))
    suspend fun patchRequest():Response<PostmodelItem> = RetrofitBuilderPOST.api.patchRequest(1, PostmodelItem( "this is NINAD",111,"PATCH REQUEST ",113))

    suspend fun deleteRequest() = RetrofitBuilderPOST.api.deletePost(1)



}
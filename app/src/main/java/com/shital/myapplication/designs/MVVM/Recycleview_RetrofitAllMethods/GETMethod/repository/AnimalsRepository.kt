package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.repository

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.network.RetrofitBuilderAnimals
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Model.Post
import retrofit2.Response

class AnimalsRepository {

    suspend fun getAnimals(): Response<List<animalsItem>> = RetrofitBuilderAnimals.api.getAllAnimals()
    suspend fun getSingleAnimals(): Response<animalsItem> = RetrofitBuilderAnimals.api.getSingleAnimal(1)
    suspend fun getCommentspostId(): Response<List<Post>> = RetrofitBuilderAnimals.api.getCommentspostId(1)

}

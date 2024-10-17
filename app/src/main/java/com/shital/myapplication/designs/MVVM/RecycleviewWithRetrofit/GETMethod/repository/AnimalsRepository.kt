package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.network.InterfaceApi
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.network.RetrofitBuilderAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.Post
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Network.RetrofitBuilder
import retrofit2.Response

class AnimalsRepository {

    suspend fun getAnimals(): Response<List<animalsItem>> = RetrofitBuilderAnimals.api.getAllAnimals()
    suspend fun getSingleAnimals(): Response<animalsItem> = RetrofitBuilderAnimals.api.getSingleAnimal(1)
    suspend fun getCommentspostId(): Response<List<Post>> = RetrofitBuilderAnimals.api.getCommentspostId(1)

}

package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Repository

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.User
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Network.RetrofitBuilderUser

class UserRepository {

    suspend fun getUser(): List<User> = RetrofitBuilderUser.api.getAllUser("karn")

}
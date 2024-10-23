package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Repository

import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Model.User
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Network.RetrofitBuilderUser

class UserRepository {

    suspend fun getUser(): List<User> = RetrofitBuilderUser.api.getAllUser("karn")

}
package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Network

import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {

    @POST("/api/users/create")
 suspend fun createUser(@Body userRequest: userRequest):Response<userResponse>

}
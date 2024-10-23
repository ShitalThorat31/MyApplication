package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Network

import android.util.Patterns
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.LoginRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.LoginResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.SignUpRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

    @POST("/api/users/create")
    suspend fun createUser(@Body userRequest: SignUpRequest): Response<SignUpResponse>

    @POST("/api/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>




}
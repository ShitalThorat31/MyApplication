package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Network

import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Model.LoginRequest
import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Model.LoginResponse
import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Model.SignUpRequest
import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Model.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

    @POST("/api/users/create")
    suspend fun createUser(@Body userRequest: SignUpRequest): Response<SignUpResponse>

    @POST("/api/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>




}
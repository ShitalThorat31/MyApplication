package com.shital.myapplication.designs.Hilt.Dragger

import com.shital.myapplication.designs.Hilt.Network.ApiServiceHilt
import com.shital.myapplication.designs.Hilt.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/* @Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getInstance(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) : ApiServiceHilt =
        retrofit.create(ApiServiceHilt::class.java)
} */
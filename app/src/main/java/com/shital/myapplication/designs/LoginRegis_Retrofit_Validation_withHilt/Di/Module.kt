package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Di

import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Network.Const
import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Network.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }



}
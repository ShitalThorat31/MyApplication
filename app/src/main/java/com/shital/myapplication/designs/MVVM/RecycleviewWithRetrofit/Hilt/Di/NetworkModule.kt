package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.Di

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.network.Constants
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.network.ProductsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)

class NetworkModule {

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ProductsApiService {
            return retrofit.create(ProductsApiService::class.java)
        }


}
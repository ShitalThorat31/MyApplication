package com.shital.myapplication.designs.Hilt.Repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shital.myapplication.designs.Hilt.Network.ApiServiceHilt
import com.shital.myapplication.designs.Hilt.model.PostHilt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepositoryHilt @Inject constructor(private val apiService: ApiServiceHilt) {

    private val postLiveData = MutableLiveData<List<PostHilt>>()

    val post: LiveData<List<PostHilt>>
        get() = postLiveData

    suspend fun getPost() {
        val result = apiService.getPosts()

        if (result.body() != null) {
            postLiveData.postValue(result.body())

        }

    }
}
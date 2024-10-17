package com.shital.myapplication.designs.Hilt.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.Hilt.Repository.PostRepositoryHilt
import com.shital.myapplication.designs.Hilt.model.PostHilt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class PostViewModelHilt @Inject constructor(private val postRepository: PostRepositoryHilt)  : ViewModel(){
    val postLiveData : LiveData<List<PostHilt>>
        get() = postRepository.post

    init {

        viewModelScope.launch(Dispatchers.IO) {

            postRepository.getPost()
        }
    }






}
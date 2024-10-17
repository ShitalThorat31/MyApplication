package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.Post
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    val myResponse: MutableLiveData<List<Post>> = MutableLiveData()
    fun getPost()
    {
        viewModelScope.launch{
            try{
                val response = postRepository.getPost()
                myResponse.value = response

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}
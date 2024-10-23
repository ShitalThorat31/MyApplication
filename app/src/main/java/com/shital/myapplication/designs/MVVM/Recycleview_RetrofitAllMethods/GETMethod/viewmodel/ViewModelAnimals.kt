package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.repository.AnimalsRepository
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Model.Post
import kotlinx.coroutines.launch

class ViewModelAnimals(private val animalsRepository: AnimalsRepository) : ViewModel() {
    val myResponse: MutableLiveData<List<animalsItem>> = MutableLiveData()
    fun getAllAnimals()
    {
        viewModelScope.launch{
            try{
                val response = animalsRepository.getAnimals()
                myResponse.value = response.body()

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }


    // ************************  get Single Animal by id(can be dynamic *************


    val singleResponse: MutableLiveData<animalsItem> = MutableLiveData()
    fun getsingleAnimals()
    {
        viewModelScope.launch{
            try{
                val response = animalsRepository.getSingleAnimals()
                singleResponse.value = response.body()

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }



    // ************************  get comments?postId(can be dynamic *************


    val commentsResponse: MutableLiveData<List<Post>> = MutableLiveData()
    fun getcommentsPostID()
    {
        viewModelScope.launch{
            try{
                val response = animalsRepository.getCommentspostId()
                commentsResponse.value = response.body()

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}
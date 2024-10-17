package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_enqueue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<UsersItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies()
    {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<UsersItem>>
        {
            override fun onResponse(call: Call<List<UsersItem>>, response: Response<List<UsersItem>>)
            {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable)
            {
                errorMessage.postValue(t.message)
            }
        })
    }
}
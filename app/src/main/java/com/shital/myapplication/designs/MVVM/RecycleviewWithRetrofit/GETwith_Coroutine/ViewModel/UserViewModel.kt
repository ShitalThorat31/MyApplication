package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.User
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val myResponse: MutableLiveData<List<User>> = MutableLiveData()
    fun getUser()
    {
        viewModelScope.launch{
            try{
                val response = userRepository.getUser()
                myResponse.value = response

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}
package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.Hilt.model.PostHilt
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.Repository.ProductsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.model.productsItem
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userLiveData : LiveData<userResponse>
        get() = userRepository.user

    fun registerUser(userRequest: userRequest)
    {
            viewModelScope.launch(Dispatchers.IO) {
                userRepository.createUser(userRequest)
        }
    }



    /*********************** 2nd method**********************************
    val userRes = MutableLiveData<userResponse>()
    fun createUser( fname: String,lname: String,username: String, password: String,email:String ,avatar: String,) {
    viewModelScope.launch() {
    val response= userRepository.createUser(fname,lname,username,password,email,avatar)

    if(response.isSuccessful){
    userRes.postValue(response.body())
    }
    else{
    Log.d("main", "createUser: ${response.errorBody()}")
    }

    }

    } */
}
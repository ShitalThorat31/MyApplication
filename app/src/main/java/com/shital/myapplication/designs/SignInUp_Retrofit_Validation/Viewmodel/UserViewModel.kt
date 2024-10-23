package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.LoginRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.LoginResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.SignUpRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.SignUpResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {



    //************************************** Registration ********************************
    val userLiveData : LiveData<SignUpResponse>
        get() = userRepository.user

    fun registerUser(userRequest: SignUpRequest)
    {
            viewModelScope.launch(Dispatchers.IO) {
                userRepository.createUser(userRequest)
        }
    }

    //**************************************LOGIN ********************************

    val loginLiveData : LiveData<LoginResponse>
       get() = userRepository.loginuser

    fun loginUser(loginRequest: LoginRequest)
    {
        viewModelScope.launch(Dispatchers.IO) {
         val response=   userRepository.loginUser(loginRequest)
            Log.d("main", "createUser: ${response}")
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
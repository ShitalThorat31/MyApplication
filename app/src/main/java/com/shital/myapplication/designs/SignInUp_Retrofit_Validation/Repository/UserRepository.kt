package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.LoginRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.LoginResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.SignUpRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.SignUpResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Network.UserApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApiService: UserApiService) {

    val userLiveData = MutableLiveData<SignUpResponse>()
    val user: LiveData<SignUpResponse>
        get() = userLiveData
    suspend fun createUser(userRequest: SignUpRequest)
            {
                //val result = userApiService.createUser(userRequest = userRequest("https://www.melivecode.com/users/cat.png","Shital",31,"Thorat","ShitalThorat"))
                val result = userApiService.createUser(userRequest)
                if (result.body() != null)
                    {
                        userLiveData.postValue(result.body())

                    }
            }

            //*********************** LOGIN  **********************************

        val loginLiveData = MutableLiveData<LoginResponse>()
        val loginuser: LiveData<LoginResponse>
           get() = loginLiveData
        suspend fun loginUser(loginRequest: LoginRequest)
        {
            //val result = userApiService.createUser(userRequest = userRequest("https://www.melivecode.com/users/cat.png","Shital",31,"Thorat","ShitalThorat"))
            val result = userApiService.loginUser(loginRequest)
            if (result.body() != null)
            {
                loginLiveData.postValue(result.body())

            }
        }




    /*********************** 2nd method  response in viewmodel **********************************

    suspend fun createUser( fname: String,lname: String,username: String, password: String,email:String ,avatar: String):Response<userResponse>
    {
    return userApiService.createUser(userRequest(fname,lname,username,password,email,avatar))
    }  */


}



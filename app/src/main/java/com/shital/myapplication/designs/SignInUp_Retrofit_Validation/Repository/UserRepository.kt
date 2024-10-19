package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shital.myapplication.designs.Hilt.Network.ApiServiceHilt
import com.shital.myapplication.designs.Hilt.model.PostHilt
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userResponse
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Network.UserApiService
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApiService: UserApiService) {

    val userLiveData = MutableLiveData<userResponse>()
    val user: LiveData<userResponse>
        get() = userLiveData

    suspend fun createUser(userRequest: userRequest)
            {
                //val result = userApiService.createUser(userRequest = userRequest("https://www.melivecode.com/users/cat.png","Shital",31,"Thorat","ShitalThorat"))
                val result = userApiService.createUser(userRequest)
                if (result.body() != null)
                    {
                        userLiveData.postValue(result.body())

                    }
            }


    /*********************** 2nd method  response in viewmodel **********************************

    suspend fun createUser( fname: String,lname: String,username: String, password: String,email:String ,avatar: String):Response<userResponse>
    {
    return userApiService.createUser(userRequest(fname,lname,username,password,email,avatar))
    }  */


}



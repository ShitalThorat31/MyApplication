package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Model

data class SignUpRequest(

    val fname: String,
    val lname: String,
    val username: String,
    val password: String,
    val email: String,
     val avatar: String,


)
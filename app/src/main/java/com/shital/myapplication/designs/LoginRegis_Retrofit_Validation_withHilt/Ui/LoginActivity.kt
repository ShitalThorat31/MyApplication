package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.databinding.ActivityLoginBinding
import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Model.LoginRequest
import com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    lateinit var userloginViewModel : UserViewModel
    lateinit var loginRequest: LoginRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val name = binding.mail.text.toString()
            val mail = binding.password.text.toString()


            loginRequest= LoginRequest(name, mail,60000)
            userloginViewModel.loginUser(loginRequest)

        }

        userloginViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userloginViewModel.loginLiveData.observe(this, { response ->
            Log.d("loginuser", response.message)
            startActivity(Intent(this, HomeActivity::class.java))
            finish()

//            if (response.status.toBoolean()) {
//                navigateToNextScreen()
//            } else {
//                Log.d("loginuser", response.message)
//
//            }
//
       })

    }

    private fun navigateToNextScreen() {
       // startActivity(Intent(this, HomeActivity::class.java))
    //    finish()


    }
}
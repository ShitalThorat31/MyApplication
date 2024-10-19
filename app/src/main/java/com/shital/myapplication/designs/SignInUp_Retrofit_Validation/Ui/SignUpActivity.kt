package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.databinding.ActivitySignupBinding
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.adapter.ProductsAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.viewModel.ProductsViewModel
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Model.userRequest
import com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    lateinit var userViewModel: UserViewModel
    lateinit var userRequest: userRequest

    // private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val name = binding.name.text.toString()
            val mail = binding.mail.text.toString()
            val password = binding.password.text.toString()
            val repassword = binding.repassword.text.toString()

            userRequest= userRequest(name, name, name, password, mail, "https://www.melivecode.com/users/cat.png")
            userViewModel.registerUser(userRequest)
        }
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.userLiveData.observe(this, { response ->
            if (response.status.toBoolean()) {
                navigateToNextScreen()
            } else {
               Log.d("createuser", response.message)

            }

        })




/*********************** 2nd method  response in viewmodel **********************************
        binding.btnSignup.setOnClickListener {
            val name = binding.name.text.toString()
            val mail = binding.mail.text.toString()
            val password = binding.password.text.toString()
            val repassword = binding.repassword.text.toString()

            userViewModel.createUser(name, name, name, password, mail, "https://www.melivecode.com/users/cat.png")
        }
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
         // userViewModel.userRes.observe(this, Observer {
        userViewModel.userRes.observe(this, { response ->
            if (response.status.toBoolean()) {
                // Handle signup success
                navigateToNextScreen()
            } else {
                // Show error message
                Log.d("createuser", response.message)

            }

             })  */



    }



    private fun navigateToNextScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()


    }
}
package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivityRegistration : AppCompatActivity() {

    lateinit var  authViewModel: AuthViewModelFirebase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        authViewModel = ViewModelProvider(this).get(AuthViewModelFirebase::class.java)

        val nameEditText = findViewById<EditText>(R.id.name)
        val emailEditText = findViewById<EditText>(R.id.mail)
        val passwordEditText = findViewById<EditText>(R.id.password)

        //val loginButton = findViewById<Button>(R.id.loginButton)
        val signupButton = findViewById<Button>(R.id.btn_signup)
        val resultTextView = findViewById<TextView>(R.id.repassword)

//        loginButton.setOnClickListener {
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//            viewModel.login(email, password)
//        }

        signupButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val name = nameEditText.text.toString()
            authViewModel.signUp(email, password, name)
        }

        authViewModel.authResult.observe(this, { result ->
            if (result.first) {

                Toast.makeText(this,"Registration successful!",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AuthActivityRegistration::class.java))
                finish()
                // Navigate to the next screen or do something else
            } else {
               // resultTextView.text = "Error: ${result.second}"
                Log.d("error", result.second.toString())
                Toast.makeText(this,result.second.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        authViewModel.validationMessage.observe(this, { message ->
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

        })
    }
}
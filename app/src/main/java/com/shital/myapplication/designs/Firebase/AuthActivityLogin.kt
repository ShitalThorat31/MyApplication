package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivityLogin  : AppCompatActivity() {

    lateinit var  authViewModel: AuthViewModelFirebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authViewModel = ViewModelProvider(this).get(AuthViewModelFirebase::class.java)


        val emailEditText = findViewById<EditText>(R.id.mail)
        val passwordEditText = findViewById<EditText>(R.id.password)

        val loginButton = findViewById<Button>(R.id.button)

        //val resultTextView = findViewById<TextView>(R.id.repassword)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            authViewModel.login(email, password)
        }



        authViewModel.authResult.observe(this, { result ->
            if (result.first) {
                Log.d("error", result.first.toString())

                //resultTextView.text = "Operation successful!"
                Toast.makeText(this,"Login successful!",Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, AuthActivityRegistration::class.java))
                finish()

            } else {
                // resultTextView.text = "Error: ${result.second}"
                Log.d("error", result.second.toString())
                Toast.makeText(this,result.second.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        authViewModel.validationMessage.observe(this, { message ->
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

        })
        }
}
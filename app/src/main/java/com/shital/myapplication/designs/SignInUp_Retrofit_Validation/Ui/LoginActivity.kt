package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shital.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {

            startActivity(Intent(this, HomeActivity::class.java))
        }
    }


}
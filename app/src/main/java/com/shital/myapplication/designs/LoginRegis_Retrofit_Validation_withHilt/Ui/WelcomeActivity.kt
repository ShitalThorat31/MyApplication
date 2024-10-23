package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shital.myapplication.databinding.ActivityWelcomeBinding


class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.registration.setOnClickListener {

            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //getSupportActionBar()?.hide();
    }
}
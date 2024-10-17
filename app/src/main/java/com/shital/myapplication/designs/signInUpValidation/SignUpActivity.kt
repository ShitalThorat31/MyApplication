package com.shital.myapplication.designs.signInUpValidation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shital.myapplication.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity()
{
    private lateinit var binding:ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)



        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignup.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
        }

        //getSupportActionBar()?.hide();
    }



}
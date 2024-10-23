package com.shital.myapplication.designs.Design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.shital.myapplication.databinding.ActivityLoginDesignBinding

class LoginActivityDesign : AppCompatActivity() {

    lateinit var bindingLogin: ActivityLoginDesignBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login_design)


        bindingLogin = ActivityLoginDesignBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)


        bindingLogin.btnLogin.setOnClickListener {
            startActivity(Intent(this, SignUpActivityDesign::class.java))
            finish()

        }

        bindingLogin.textViewSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivityDesign::class.java))
            finish()

        }

        val callback= object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Back is pressed... Finishing the activity

                Log.d("Activity", "finished")
                Toast.makeText(this@LoginActivityDesign, "finished", Toast.LENGTH_LONG).show()
                finish()
            }
        }


        onBackPressedDispatcher.addCallback(callback)


    }

}
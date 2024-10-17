package com.shital.myapplication.designs.others

import android.content.Intent
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BuildCompat
import com.shital.myapplication.databinding.ActivitySignUpDesignBinding

class SignUpActivityDesign : AppCompatActivity() {


    lateinit var bindingSignUp:ActivitySignUpDesignBinding

    val callback= object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            // Back is pressed... Finishing the activity
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_sign_up_design)

        bindingSignUp= ActivitySignUpDesignBinding.inflate(layoutInflater)
        setContentView(bindingSignUp.root)


        bindingSignUp.textView9.setOnClickListener {
            startActivity(Intent(this,LoginActivityDesign::class.java))
            finish()

        }

        bindingSignUp.button2.setOnClickListener {
            startActivity(Intent(this,LoginActivityDesign::class.java))
            finish()

        }


        onBackPressedDispatcher.addCallback(this ,callback)
        callback.isEnabled=true




    }

}
package com.example.myapplication.startActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class Activity1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)


        val btnOpen= findViewById<Button>(R.id.button)

        btnOpen.setOnClickListener(){


            val age: Int = 27
            val age2: Int = 272

            val result = age + age2

            Toast.makeText(this,"Addition is:"+result,Toast.LENGTH_LONG).show()
           // val intent= Intent(this,Activity2::class.java)
            //startActivity(intent)
        }

    }
}
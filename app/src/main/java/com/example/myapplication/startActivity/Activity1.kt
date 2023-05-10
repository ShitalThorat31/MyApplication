package com.example.myapplication.startActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class Activity1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)


        val btnOpen= findViewById<Button>(R.id.button)

        btnOpen.setOnClickListener(){
            val intent= Intent(this,Activity2::class.java)
            startActivity(intent)
        }

    }
}
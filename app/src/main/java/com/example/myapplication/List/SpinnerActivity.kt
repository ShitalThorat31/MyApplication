package com.example.myapplication.List

import android.os.Bundle
import android.os.PersistableBundle
import android.provider.CalendarContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SpinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner)
        val list = findViewById<Spinner>(R.id.spinner)
        val user = arrayOf("SHital", "NINAD", "JAYESH", "SARIKA")
        val arrayadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, user)

        //list.adapter=arrayadapter
        list.setAdapter(arrayadapter)


    }

}
package com.example.myapplication.List

import android.os.Bundle
import android.os.PersistableBundle
import android.provider.CalendarContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class List : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.listactivity)
        val list = findViewById<ListView>(R.id.list)
        val user = arrayOf("SHital", "NINAD", "JAYESH", "SARIKA")
        val arrayadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, user)

        //list.adapter=arrayadapter
        list.setAdapter(arrayadapter)

        list.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "You have clicked on" + position, Toast.LENGTH_LONG).show()
        }

    }

}
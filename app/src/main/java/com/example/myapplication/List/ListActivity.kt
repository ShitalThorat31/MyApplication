package com.example.myapplication.List

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R


class ListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listactivity)

        val list=findViewById<ListView>(R.id.list)
        val users = arrayOf(
            "Virat Kohli", "Rohit Sharma", "Steve Smith",
            "Kane Williamson", "Ross Taylor"
        )
       // val arrayAdapter: ArrayAdapter<*>
        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
        list.adapter = arrayAdapter

    }
}
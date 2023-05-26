package com.example.myapplication.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.JSON.Parsing.MyAdapter
import com.example.myapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestCoRoutines: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {

            while (true){
                delay(1000)
                Log.d("TestCoRoutines","GlobaleScope Runnning")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TestCoRoutines","Destoryed")
    }
}
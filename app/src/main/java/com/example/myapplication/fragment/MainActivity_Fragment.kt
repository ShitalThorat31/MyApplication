package com.example.myapplication.fragment


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R

class MainActivity_Fragment : AppCompatActivity() {

    private lateinit var first_frg:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment_activity)

        //first_frg=this.findNavController(R.id.first_frg)
       // NavigationUI.setupActionBarWithNavController(this,first_frg)
    }
}
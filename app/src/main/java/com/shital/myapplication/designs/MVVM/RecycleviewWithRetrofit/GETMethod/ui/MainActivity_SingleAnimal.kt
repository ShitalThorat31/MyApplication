package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.databinding.ActivityMainRecycleviewBinding
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter.AnimalsAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter.RecyclerAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.repository.AnimalsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelFactoryAnimals

class MainActivity_SingleAnimal : AppCompatActivity() {
    private lateinit var binding: ActivityMainRecycleviewBinding

    private lateinit var animalsRepository: AnimalsRepository
    private lateinit var viewModelFactoryAnimals: ViewModelFactoryAnimals
    private lateinit var viewModelAnimals: ViewModelAnimals

    private lateinit var animalsAdapter: RecyclerAdapter
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        animalsRepository = AnimalsRepository()
        viewModelFactoryAnimals = ViewModelFactoryAnimals(animalsRepository)
        viewModelAnimals =
            ViewModelProvider(this, viewModelFactoryAnimals).get(ViewModelAnimals::class.java)



        // ************* get Single Animals *********
        viewModelAnimals.getsingleAnimals()
        viewModelAnimals.singleResponse.observe(this, Observer {


            animalsAdapter = RecyclerAdapter(listOf(it))
            recyclerView.adapter = animalsAdapter

            recyclerView.visibility = View.VISIBLE
            Log.d(
                "main", it.toString()
            )
        })

    }




}
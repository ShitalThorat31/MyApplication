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
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.network.InterfaceApi
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.repository.AnimalsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelFactoryAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Adapter.PostAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.Post
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Repository.PostRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel.PostViewModelFactory
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel.ViewModelPostMethod
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_enqueue.MainAdapter

class MainActivityGETMethod : AppCompatActivity() {
    private lateinit var binding: ActivityMainRecycleviewBinding

    private lateinit var animalsRepository: AnimalsRepository
    private lateinit var viewModelFactoryAnimals: ViewModelFactoryAnimals
    private lateinit var viewModelAnimals: ViewModelAnimals
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalsAdapter: AnimalsAdapter
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)
        initRecyclerView()

        animalsRepository = AnimalsRepository()
        viewModelFactoryAnimals = ViewModelFactoryAnimals(animalsRepository)
        viewModelAnimals =
            ViewModelProvider(this, viewModelFactoryAnimals).get(ViewModelAnimals::class.java)

        // ************* get All Animals *********
        /*
        viewModelAnimals.getAllAnimals()
        viewModelAnimals.myResponse.observe(this, Observer {

            animalsAdapter.setPostData(it as ArrayList<animalsItem>)

            recyclerView.visibility = View.VISIBLE
            Log.d(
                "main", it.toString()
            )
        }) */

        // ************* get Single Animals *********
        viewModelAnimals.getsingleAnimals()
        viewModelAnimals.singleResponse.observe(this, Observer {

            animalsAdapter = AnimalsAdapter(this,listOf(it))
            recyclerView.adapter = animalsAdapter


            recyclerView.visibility = View.VISIBLE
            Log.d(
                "main", it.toString()
            )
        })

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        animalsAdapter = AnimalsAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivityGETMethod)
            adapter = animalsAdapter
        }
    }


}
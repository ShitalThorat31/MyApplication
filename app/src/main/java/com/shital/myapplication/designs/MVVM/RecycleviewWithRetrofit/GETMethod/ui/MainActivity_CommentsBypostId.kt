package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.databinding.ActivityMainRecycleviewBinding
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter.RecyclerAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter.RecyclerAdapterPost
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.repository.AnimalsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelFactoryAnimals

class MainActivity_CommentsBypostId : AppCompatActivity() {
    private lateinit var binding: ActivityMainRecycleviewBinding

    private lateinit var animalsRepository: AnimalsRepository
    private lateinit var viewModelFactoryAnimals: ViewModelFactoryAnimals
    private lateinit var viewModelAnimals: ViewModelAnimals

    private lateinit var recyclerAdapterPost: RecyclerAdapterPost
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        animalsRepository = AnimalsRepository()
        viewModelFactoryAnimals = ViewModelFactoryAnimals(animalsRepository)
        viewModelAnimals =
            ViewModelProvider(this, viewModelFactoryAnimals).get(ViewModelAnimals::class.java)



        // ************* get  CommentspostId *********
        viewModelAnimals.getcommentsPostID()
        viewModelAnimals.commentsResponse.observe(this, Observer {

  recyclerAdapterPost = RecyclerAdapterPost(it)
            recyclerView.adapter = recyclerAdapterPost

            recyclerView.visibility = View.VISIBLE
            Log.d(
                "main", it.toString()
            )
        })

    }




}
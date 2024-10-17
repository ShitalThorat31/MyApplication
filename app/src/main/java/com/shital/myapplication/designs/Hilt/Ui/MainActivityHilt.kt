package com.shital.myapplication.designs.Hilt.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.Hilt.Repository.PostRepositoryHilt
import com.shital.myapplication.designs.Hilt.ViewModel.PostViewModelHilt

import com.shital.myapplication.designs.Hilt.adapter.PostAdapterHilt
import com.shital.myapplication.designs.Hilt.model.PostHilt
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter.RecyclerAdapterPost
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.repository.AnimalsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelAnimals
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel.ViewModelFactoryAnimals
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class MainActivityHilt : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapterHilt
    lateinit var postViewModel: PostViewModelHilt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivityHilt)


        postViewModel = ViewModelProvider(this).get(PostViewModelHilt::class.java)
        postViewModel.postLiveData.observe(this, Observer {

            postAdapter = PostAdapterHilt(it)
            recyclerView.adapter = postAdapter

            Log.d("main", it.toString())
        })

    }

}
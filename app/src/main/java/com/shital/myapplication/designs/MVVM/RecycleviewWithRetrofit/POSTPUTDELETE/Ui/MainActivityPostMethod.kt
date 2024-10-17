package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.POSTPUTDELETE.Ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel.ViewModelPostMethod
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel.ViewModelFactory
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.POSTPUTDELETE.Repository.RepositoryPOST
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.POSTPUTDELETE.adapter.AdapterPost

class MainActivityPostMethod : AppCompatActivity() {
    private lateinit var postRepository: RepositoryPOST
    private lateinit var postViewModelFactory: ViewModelFactory
    private lateinit var postViewModelPostMethod: ViewModelPostMethod
    private lateinit var adapterPost:  AdapterPost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        postRepository= RepositoryPOST()
        postViewModelFactory= ViewModelFactory(postRepository)
        postViewModelPostMethod= ViewModelProvider(this,postViewModelFactory).get(ViewModelPostMethod::class.java)

        postViewModelPostMethod.getPost()

        postViewModelPostMethod.myResponse.observe(this, Observer {
           //  Log.d("this","POST Created")
            adapterPost = AdapterPost(listOf(it))
            recyclerView.adapter = adapterPost
            Log.d("this", "onCreate: $it")
            recyclerView.visibility=View.VISIBLE
        })

    }


}
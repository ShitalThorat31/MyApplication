package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_enqueue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shital.myapplication.databinding.ActivityMainRecycleviewBinding


class MainActivity_MVVMRecycleview : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainRecycleviewBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    lateinit var myAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main_recycleview)

        binding = ActivityMainRecycleviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)

        viewModel.getAllMovies()


        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")

            myAdapter = MainAdapter(baseContext,it)

            binding.recyclerview.adapter  = myAdapter

            Log.d("data",it.toString())
        })

        viewModel.errorMessage.observe(this, Observer {

        })






    }



}
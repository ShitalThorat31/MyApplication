package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Adapter.UserAdapter
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Model.User
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.Repository.UserRepository
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.ViewModel.UserViewModel
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_Coroutine.ViewModel.UserViewModelFactory

class MainActivityGETUser : AppCompatActivity() {
    private lateinit var userRepository: UserRepository
    private lateinit var userViewModelFactory: UserViewModelFactory
    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post)

        initRecyclerView()

        userRepository= UserRepository()
        userViewModelFactory= UserViewModelFactory(userRepository)
        userViewModel= ViewModelProvider(this,userViewModelFactory).get(UserViewModel::class.java)

        userViewModel.getUser()

        userViewModel.myResponse.observe(this, Observer {
            userAdapter.setPostData(it as ArrayList<User>)
           // Log.d("main", it[0].title)
           // progressBar.visibility= View.GONE
            recyclerView.visibility=View.VISIBLE
        })

    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        userAdapter= UserAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivityGETUser)
            adapter=userAdapter
        }
    }
}
package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.Post
import retrofit2.http.POST

class RecyclerAdapterPost (val list: List<Post>) : RecyclerView.Adapter<RecyclerAdapterPost.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title)

        val id = view.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterPost.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterPost.MyViewHolder, position: Int) {
        holder.title.text = list[position].name

        holder.id.text = list[position].id.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
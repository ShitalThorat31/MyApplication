package com.shital.myapplication.designs.Hilt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.Hilt.model.PostHilt
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.model.animalsItem

class PostAdapterHilt  (val list: List<PostHilt>) : RecyclerView.Adapter<PostAdapterHilt.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title)

       // val id = view.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapterHilt.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapterHilt.MyViewHolder, position: Int) {
        holder.title.text = list[position].body

       // holder.id.text = list[position].id.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
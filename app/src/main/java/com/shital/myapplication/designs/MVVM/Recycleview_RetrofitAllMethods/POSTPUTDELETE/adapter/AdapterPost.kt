package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shital.myapplication.R
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.POSTPUTDELETE.Model.PostmodelItem

class AdapterPost (val list: List<PostmodelItem>) : RecyclerView.Adapter<AdapterPost.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title)

        val id = view.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPost.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterPost.MyViewHolder, position: Int) {
        holder.title.text = list[position].title

        holder.id.text = list[position].id.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
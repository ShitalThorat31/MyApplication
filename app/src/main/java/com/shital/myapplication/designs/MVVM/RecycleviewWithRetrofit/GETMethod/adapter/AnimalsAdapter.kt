package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shital.myapplication.R
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.model.animalsItem
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Adapter.PostAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.Post
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_enqueue.MainAdapter
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_enqueue.UsersItem
import retrofit2.Response

class AnimalsAdapter(var con: Context, var list:  List<animalsItem>) : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>() {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v)
    {
        var img = v.findViewById<ImageView>(R.id.imgMovie)
        var tvName = v.findViewById<TextView>(R.id.txtName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.adapter_movie,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(con).load(list[position].image).into(holder.img)

        holder.tvName.text = list[position].name

    }

    override fun getItemCount(): Int {
        return list.count()
    }

    fun setPostData(list: ArrayList<animalsItem>)
    {
        this.list=list
        notifyDataSetChanged()
    }


    fun setSingleData(list: animalsItem)
    {

        notifyDataSetChanged()
    }

}
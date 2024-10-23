package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETwith_enqueue
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shital.myapplication.R

class MainAdapter(var con : Context, var list : List<UsersItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

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

        Glide.with(con).load(list[position].avatar).into(holder.img)

        holder.tvName.text = list[position].fname

    }

    override fun getItemCount(): Int {
        return list.count()
    }

}
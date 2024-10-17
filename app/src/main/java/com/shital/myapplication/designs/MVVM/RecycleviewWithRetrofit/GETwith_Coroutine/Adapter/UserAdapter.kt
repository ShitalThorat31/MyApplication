package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shital.myapplication.R
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Model.User

class UserAdapter(private val context: Context, private var userList:ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie,parent,false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val post=userList[position]
        holder.fname.text=post.fname.toString()
       // holder.img.text=post.avatar

        Glide.with(context).load(userList[position].avatar).into(holder.img)

    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val fname: TextView =itemView.findViewById(R.id.txtName)
        val img:ImageView=itemView.findViewById(R.id.imgMovie)
    }

    fun setPostData(userList: ArrayList<User>)
    {
        this.userList=userList
        notifyDataSetChanged()
    }
}
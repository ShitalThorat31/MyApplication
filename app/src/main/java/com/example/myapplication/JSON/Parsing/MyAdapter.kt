package com.example.myapplication.JSON.Parsing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyAdapter(val context:Context, val userlist: List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>()  {

    class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView)
    {




        val userId = itemView.findViewById<TextView>(R.id.txtUserId)
        val title = itemView.findViewById<TextView>(R.id.txtTitle)





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.raw_items, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.userId.text=userlist[position].id.toString()
        holder.title.text=userlist[position].title.toString()
    }


}
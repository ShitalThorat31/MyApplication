package com.example.myapplication.JSON.Parsing

import com.google.gson.annotations.SerializedName

data class MyDataItem(
    // @SerializedName(value = "body") - if you want to give another name in that case we use this
    //val my_body: String,
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
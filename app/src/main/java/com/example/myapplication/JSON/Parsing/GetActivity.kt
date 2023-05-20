package com.example.myapplication.JSON.Parsing

import android.content.Intent
import android.net.Uri

import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest

import com.example.myapplication.R

import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONObject

class GetActivity:AppCompatActivity() {

    // on below line we are creating variables
    // for our text view, image view and progress bar
    lateinit var courseNameTV: TextView
    lateinit var courseDescTV: TextView
    lateinit var courseReqTV: TextView
    lateinit var courseIV: ImageView
    lateinit var visitCourseBtn: Button
   // lateinit var loadingPB: ProgressBar

    // on below line we are creating a variable for our url.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_jsonparsing)

        // on below line we are initializing our variable with their ids.
        courseNameTV = findViewById(R.id.idTVCourseName)
        courseDescTV = findViewById(R.id.idTVDesc)
        courseReqTV = findViewById(R.id.idTVPreq)
        courseIV = findViewById(R.id.idIVCourse)
        visitCourseBtn = findViewById(R.id.idBtnVisitCourse)
        getUsers()
        }

    fun getUsers() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        //val url: String = "https://api.github.com/search/users?q=eyehunt"
        val url: String = "https://www.jsonkeeper.com/b/8RFY"
        // Request a string response from the provided URL.
        val stringReq = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->

                var strResp = response.toString()
                val jsonObj: JSONObject = JSONObject(strResp)

                val courseName: String = jsonObj.getString("courseName")
                val courseLink: String = jsonObj.getString("courseLink")
                val courseImg: String = jsonObj.getString("courseimg")
                val courseDesc: String = jsonObj.getString("courseDesc")
                val coursePreq: String = jsonObj.getString("Prerequisites")
                /*val jsonArray: JSONArray = jsonObj.getJSONArray("items")
                var str_user: String = ""
                for (i in 0 until jsonArray.length()) {
                    var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                    str_user = str_user + "\n" + jsonInner.get("login")
                }*/
                courseReqTV.text = coursePreq
                courseDescTV.text = courseDesc
                courseNameTV.text = courseName
                Picasso.get().load(courseImg).into(courseIV)
            },
            Response.ErrorListener {  "That didn't work!" })
        queue.add(stringReq)
    }
}
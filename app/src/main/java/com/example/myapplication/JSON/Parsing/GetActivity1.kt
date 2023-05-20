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

class GetActivity1:AppCompatActivity() {

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
        val url: String = "{\n" +
                "   \"users\":[\n" +
                "      {\n" +
                "         \"name\":\"Niyaz\",\n" +
                "         \"email\":\"testemail1@gmail.com\",\n" +
                "         \"contact\":{\n" +
                "            \"mobile\":\"+91 0000000000\"\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\":\"Azhar\",\n" +
                "         \"email\":\"testemail2@gmail.com\",\n" +
                "         \"contact\":{\n" +
                "            \"mobile\":\"+91 0000000000\"\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\":\"Mahi\",\n" +
                "         \"email\":\"testemail3@gmail.com\",\n" +
                "         \"contact\":{\n" +
                "            \"mobile\":\"+91 0000000000\"\n" +
                "         }\n" +
                "      }\n" +
                "   ]\n" +
                "}"
        // Request a string response from the provided URL.
        val stringReq = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->

                var strResp = response.toString()
                val jsonObj: JSONObject = JSONObject(strResp)
                val jsonArray: JSONArray = jsonObj.getJSONArray("users")
                for (i in 0 until jsonArray.length()) {
                    var jsonInner: JSONObject = jsonArray.getJSONObject(i)

                    var jsonInner2: JSONObject = jsonInner.getJSONObject("contact")


                val courseName: String = jsonInner.getString("name")
                val courseLink: String = jsonInner.getString("email")
                val courseImg: String = jsonInner2.getString("mobile")

                /*
                var str_user: String = ""
                for (i in 0 until jsonArray.length()) {
                    var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                    str_user = str_user + "\n" + jsonInner.get("login")
                }*/
                courseReqTV.text = courseName
                courseDescTV.text = courseLink
                courseNameTV.text = courseImg
               // Picasso.get().load(courseImg).into(courseIV)
                }

            },
            Response.ErrorListener {  "That didn't work!" })
        queue.add(stringReq)
    }
}
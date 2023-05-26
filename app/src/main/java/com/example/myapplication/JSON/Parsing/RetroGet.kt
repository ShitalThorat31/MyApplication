package com.example.myapplication.JSON.Parsing

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder


class RetroGet:AppCompatActivity() {
      val BASE_URL="https://jsonplaceholder.typicode.com/"
    lateinit var txtId: TextView
    var titleName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        txtId = findViewById(R.id.txtId)
        getMyData()
    }

    private fun getMyData()
    {
        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData=retrofitBuilder.getData()

        //enqueue( ctrl+shift+space for () code
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody=response.body()!! // null safty check not null error in for loop

              val myStringBuilder=StringBuilder()
                for (myData in responseBody)
                {

                   //titleName= myData.title
                 myStringBuilder.append(myData.id)
                myStringBuilder.append("\n")


                }
                txtId.text= myStringBuilder



            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
            Log.d("RetoGet","onFailure:"+t.message)
                Toast.makeText(this@RetroGet, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}
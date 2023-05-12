package com.example.myapplication.toolbar
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.startActivity.Activity2

class CToolbarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cust_toolbar)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this,"Navigation",Toast.LENGTH_SHORT).show()



        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.action_search -> Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
            R.id.action_settings -> Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }
}
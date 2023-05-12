package com.example.myapplication.toolbar
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.startActivity.Activity2

class ToolbarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbaractivity)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.action_search -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
            R.id.action_settings -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.action_share -> {

                Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
                val intent= Intent(this, Activity2::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.myapplication.navigationDrawer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myapplication.R
import com.google.android.material.navigation.NavigationView


class NavigationActivity: AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_home)
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Handle navigation view item clicks here.
            when (menuItem.itemId) {

                R.id.profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
                }
                R.id.print -> {
                    Toast.makeText(this, "Wallet", Toast.LENGTH_LONG).show()
                }
                R.id.settings -> {
                    Toast.makeText(this, "Offer", Toast.LENGTH_LONG).show()
                }
                R.id.rating -> {
                    Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show()
                }
            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }
    }

    //appbar - toolbar button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_share -> {
                Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
                true
            }




            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custmenu,menu)
        return true
    }


}
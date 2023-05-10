package com.example.myapplication.animation

import android.os.Bundle

import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class Animation_Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation)


        val txtAnimation= findViewById<TextView>(R.id.txtAnimation)



        val btnTranslate= findViewById<Button>(R.id.btnTranslate)
        val btnScale= findViewById<Button>(R.id.btnScale)
        val btnAlpha= findViewById<Button>(R.id.btnAlpha)
        val btnRotate= findViewById<Button>(R.id.btnRotate)



        btnTranslate.setOnClickListener(){
            val anm= AnimationUtils.loadAnimation(this,R.anim.move)
            txtAnimation.startAnimation(anm)
        }
        btnScale.setOnClickListener(){
            val anm= AnimationUtils.loadAnimation(this,R.anim.scale)
            txtAnimation.startAnimation(anm)
        }
        btnAlpha.setOnClickListener(){
            val anm= AnimationUtils.loadAnimation(this,R.anim.alpha)
            txtAnimation.startAnimation(anm)
        }
        btnRotate.setOnClickListener(){
            val anm= AnimationUtils.loadAnimation(this,R.anim.rotation)
            txtAnimation.startAnimation(anm)
        }


    }
}
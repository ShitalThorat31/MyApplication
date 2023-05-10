package com.example.myapplication.lottieAnimation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R


class LottieAnimationActivity: AppCompatActivity() {
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lottieanimation)

        val lotti= findViewById<LottieAnimationView>(R.id.lottiAnimation)
        lotti.setAnimation(R.raw.loader)
        lotti.playAnimation()
        lotti.loop(true)


       /* btnTranslate.setOnClickListener(){
            val anm= AnimationUtils.loadAnimation(this,R.anim.move)
            txtAnimation.startAnimation(anm)
        }
        */


    }
}
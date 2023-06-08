package com.example.spinbottol

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    private var bot: ImageView? = null
    private val rand: Random = Random()
    private var lstDr = 0
    private var spn = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bot = findViewById(R.id.bottle);

    }

    fun spinBottle(v: View?) {
        // check if the bottled has stopped spinning
        if (!spn) {

            // generate a random number from 1-1800
            val num = rand.nextInt(1800)

            // set the pivot to the centre of the image
            val pX = (bot!!.width / 2).toFloat()
            val pY = (bot!!.height / 2).toFloat()

            // pass parameters in RoatateAnimation function
            val rot: Animation = RotateAnimation(lstDr.toFloat(), num.toFloat(), pX, pY)

            // set rotate duration 4000 millisecs
            rot.duration = 4000

            // rotation will persist after finishing
            rot.fillAfter = true

            rot.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    spn = true
                }

                override fun onAnimationEnd(animation: Animation) {
                    spn = false
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })

            // change the last direction
            lstDr = num

            // start the animation
            bot!!.startAnimation(rot)
        }
    }
}
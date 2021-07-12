package com.bored.boredom.getbored.boredashell.theboredbutton.views.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bored.boredom.getbored.boredashell.theboredbutton.R
import com.bored.boredom.getbored.boredashell.theboredbutton.views.home.HomeActivity
import com.startapp.sdk.adsbase.StartAppAd
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        StartAppAd.disableSplash()

        hideSystemUI(this)

        val time1: Long = 2000
        val time2: Long = 3000

        Handler().postDelayed(Runnable {

            logo_splash.setImageResource(R.drawable.dislike)
            Handler().postDelayed(Runnable {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }, time2)

        }, time1)

    }

    private fun hideSystemUI(activity: Activity) {
        val decorView = activity.window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                //| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }


}
package com.bored.boredom.getbored.boredashell.theboredbutton.views.videos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bored.boredom.getbored.boredashell.theboredbutton.databinding.ActivityVideosBinding
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Credentials.YOUTUBE_DIY
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Credentials.YOUTUBE_FUNNY_TIKTOk
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Credentials.YOUTUBE_MAGIC
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Credentials.YOUTUBE_SCIENCE
import com.bored.boredom.getbored.boredashell.theboredbutton.views.videos.genere.videos.GenereActivity
import maes.tech.intentanim.CustomIntent

class VideosActivity : AppCompatActivity() {
    lateinit var binding: ActivityVideosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.diyBtn.setOnClickListener {
            val i = Intent(this, GenereActivity::class.java)
            i.putExtra("genre", YOUTUBE_DIY)
            startActivity(i)
            CustomIntent.customType(this, "left-to-right")
        }

        binding.magicBtn.setOnClickListener {
            val i = Intent(this, GenereActivity::class.java)
            i.putExtra("genre", YOUTUBE_MAGIC)
            startActivity(i)
            CustomIntent.customType(this, "left-to-right")
        }

        binding.scienceBtn.setOnClickListener {
            val i = Intent(this, GenereActivity::class.java)
            i.putExtra("genre", YOUTUBE_SCIENCE)
            startActivity(i)
            CustomIntent.customType(this, "left-to-right")
        }

        binding.tiktokBtn.setOnClickListener {
            val i = Intent(this, GenereActivity::class.java)
            i.putExtra("genre", YOUTUBE_FUNNY_TIKTOk)
            startActivity(i)
            CustomIntent.customType(this, "left-to-right")
        }

    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "right-to-left")
    }

}
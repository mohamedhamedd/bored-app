package com.bored.boredom.getbored.boredashell.theboredbutton.views.videos.genere.videos

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bored.boredom.getbored.boredashell.theboredbutton.databinding.ActivityGenereBinding
import com.bored.boredom.getbored.boredashell.theboredbutton.utilis.Credentials.YOUTUBE_API_KEY
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import maes.tech.intentanim.CustomIntent

class GenereActivity : YouTubeBaseActivity() {

    lateinit var binding: ActivityGenereBinding
    private var onInitializedListener: YouTubePlayer.OnInitializedListener? = null
    lateinit var YOUTUBE_PLAYLIST: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenereBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideSystemUI(this)
        YOUTUBE_PLAYLIST = intent.getStringExtra("genre").toString()


        onInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider,
                    youTubePlayer: YouTubePlayer,
                    b: Boolean
            ) {
                youTubePlayer.loadPlaylist(YOUTUBE_PLAYLIST)
            }

            override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider,
                    youTubeInitializationResult: YouTubeInitializationResult
            ) {
                Toast.makeText(
                        binding.root.context,
                        youTubeInitializationResult.name.toString(),
                        Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.youtubePlayer.initialize(YOUTUBE_API_KEY, onInitializedListener)

    }

    private fun hideSystemUI(activity: Activity) {
        val decorView = activity.window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                //| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "right-to-left")
    }
}
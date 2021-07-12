package com.bored.boredom.getbored.boredashell.theboredbutton.views.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.bored.boredom.getbored.boredashell.theboredbutton.R
import com.bored.boredom.getbored.boredashell.theboredbutton.databinding.ActivityHomeBinding
import com.bored.boredom.getbored.boredashell.theboredbutton.views.videos.VideosActivity
import com.bored.boredom.getbored.boredashell.theboredbutton.views.webview.WebViewActivity
import hotchemi.android.rate.AppRate
import kotlinx.android.synthetic.main.activity_home.*
import maes.tech.intentanim.CustomIntent
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), IHomeInterface, KodeinAware, IProperties {
    override val kodein: Kodein by kodein()
    private val factory: HomeViewModelFactory by instance()
    lateinit var viewModel: HomeViewModel

    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        viewModel.iHomeInterface = this
        viewModel.IProperties = this
        binding.viewModel = viewModel
        viewModel.getActivity()
        RateUs()

    }

    override fun onStarted() {
        error_txt.visibility = View.GONE
        progress_error.visibility = View.VISIBLE
        tryagain_txt.visibility = View.GONE
        progress_layout.visibility = View.VISIBLE
    }

    override fun onSuccess(
        accessibility: Double?,
        activity: String?,
        participants: Int?,
        price: Double?,
        type: String?
    ) {
        type_text.text = type
        activity_txt.text = activity
        participants_txt.text = participants.toString()
        accessibility_txt.text = "$accessibility%"
        progress_accessibility.progress = accessibility!!.toInt()
        price_text.text = "$price%"
        progress_price.progress = price!!.toInt()

        tryagain_txt.visibility = View.GONE
        progress_layout.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        error_txt.text = message
        progress_error.visibility = View.GONE
        img_error.visibility = View.VISIBLE
        tryagain_txt.visibility = View.VISIBLE
    }

    override fun onNull(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onHasLink(link: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("link", link)
        startActivity(intent)
        CustomIntent.customType(this, "left-to-right")
    }

    override fun openVideos() {
        val intent = Intent(this, VideosActivity::class.java)
        startActivity(intent)
        CustomIntent.customType(this, "left-to-right")
    }

    fun RateUs(){
        AppRate.with(this)
            .setInstallDays(1) // default 10, 0 means install day.
            .setLaunchTimes(3) // default 10
            .setRemindInterval(2) // default 1
            .monitor()

        // Show a dialog if meets conditions
        AppRate.showRateDialogIfMeetsConditions(this);

    }
}
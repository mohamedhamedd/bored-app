package com.bored.boredom.getbored.boredashell.theboredbutton.views.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.bored.boredom.getbored.boredashell.theboredbutton.R
import kotlinx.android.synthetic.main.activity_web_view.*
import maes.tech.intentanim.CustomIntent


class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val link = intent.getStringExtra("link").toString()
        webview.webViewClient = WebViewClient()
        webview.loadUrl(link)
        val webSettings: WebSettings = webview.settings
        webSettings.javaScriptEnabled = true

    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "right-to-left")
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
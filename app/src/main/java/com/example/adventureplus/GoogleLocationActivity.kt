package com.example.adventureplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class GoogleLocationActivity : AppCompatActivity() {

    lateinit var googleLocationBtn: Button
    lateinit var googleWebview: WebView
    lateinit var backPageBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_location)

        googleLocationBtn = findViewById(R.id.googleWebpageBtn)
        googleWebview = findViewById(R.id.googleWebpage)
        backPageBtn = findViewById(R.id.backbageBtn)

        googleLocationBtn.setOnClickListener {
            googleWebview.webViewClient = WebViewClient()
            googleWebview.loadUrl("https://www.google.com/maps/place/Britam+Tower")
            googleWebview.settings.javaScriptEnabled = true
            googleWebview.settings.setSupportZoom(true) }

        backPageBtn.setOnClickListener {
            val nextpage = Intent(this,DashBoardActivity::class.java)
            startActivity(nextpage) }

    }
}
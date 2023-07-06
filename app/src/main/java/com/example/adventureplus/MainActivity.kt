package com.example.adventureplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var splashimage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashimage = findViewById(R.id.splashLogo)
        splashimage.alpha = 0f
        splashimage.animate().setDuration(2000).alpha(1f).withEndAction {
            val next = Intent(this,LoginActivity::class.java)
            startActivity(next)
            finish()
        }
    }
}
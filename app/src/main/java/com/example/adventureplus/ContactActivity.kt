package com.example.adventureplus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ContactActivity : AppCompatActivity() {

    lateinit var callBtn: ImageView
    lateinit var emailBtn: ImageView
    lateinit var textSmsBtn:ImageView
    lateinit var locationLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        callBtn = findViewById(R.id.callBtn)
        emailBtn = findViewById(R.id.emailBtn)
        textSmsBtn = findViewById(R.id.textSmsBtn)
        locationLink = findViewById(R.id.locationLink)

        callBtn.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "0717833348")
            startActivity(dialIntent) }

        emailBtn.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","benkarue20@gmail.com",null))
            startActivity(Intent.createChooser(emailIntent,"Send email")) }

        textSmsBtn.setOnClickListener {
            val uri = Uri.parse("smsto:0717833348 ")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body","Hi AdventurePlus+ Customer Care, Kindly book my trip.")
            startActivity(intent) }

        locationLink.setOnClickListener {
            val nextpage = Intent(this,GoogleLocationActivity::class.java)
            startActivity(nextpage)
        }


    }
}
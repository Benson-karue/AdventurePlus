package com.example.adventureplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {

     lateinit var bookinBtn1 : Button
     lateinit var bookinBtn2 : Button
     lateinit var bookinBtn3 : Button
     lateinit var bookinBtn4 : Button
     lateinit var backpageBtn: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bookinBtn1 = findViewById(R.id.HomeBookingBtn1)
        bookinBtn2 = findViewById(R.id.HomeBookingBtn2)
        bookinBtn3 = findViewById(R.id.HomeBookingBtn3)
        bookinBtn4 = findViewById(R.id.HomeBookingBtn4)
        backpageBtn = findViewById(R.id.backpagearrow)

        bookinBtn1.setOnClickListener {
            val nextpage = Intent(this,BookingPageActivity::class.java)
            startActivity(nextpage)}

        bookinBtn2.setOnClickListener {
            val nextpage = Intent(this,BookingPageActivity::class.java)
            startActivity(nextpage)}

        bookinBtn3.setOnClickListener {
            val nextpage = Intent(this,BookingPageActivity::class.java)
            startActivity(nextpage)}

        bookinBtn4.setOnClickListener {
            val nextpage = Intent(this,BookingPageActivity::class.java)
            startActivity(nextpage)}

        backpageBtn.setOnClickListener {
            val nextpage = Intent(this,DashBoardActivity::class.java)
            startActivity(nextpage)}

    }
}
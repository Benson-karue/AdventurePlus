package com.example.adventureplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashBoardActivity : AppCompatActivity() {

    lateinit var SeeAllBtn : TextView
    lateinit var contactBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        SeeAllBtn = findViewById(R.id.SeeAllBtnTV)
        contactBtn = findViewById(R.id.contactBtn)

        SeeAllBtn.setOnClickListener {
            val nextpage = Intent(this,HomeActivity::class.java)
            startActivity(nextpage) }

        contactBtn.setOnClickListener {
            val nextpage = Intent(this,ContactActivity::class.java)
            startActivity(nextpage) }

    }
}
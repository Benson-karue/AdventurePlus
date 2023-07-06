package com.example.adventureplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var myemail: EditText
    lateinit var mypassword :EditText
    lateinit var myforgotpasswordLink: TextView
    lateinit var myLoginBtn :Button
    lateinit var mySignupLink: TextView
    private lateinit var authenticate : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myemail = findViewById(R.id.editTextEmail)
        mypassword = findViewById(R.id.editTextPassword)
        myforgotpasswordLink = findViewById(R.id.tvForgotPassword)
        myLoginBtn = findViewById(R.id.loginBtn)
        authenticate = Firebase.auth

        // code for signuplink
        mySignupLink = findViewById(R.id.signup_link)
        mySignupLink.setOnClickListener {
            val back = Intent(this,SignUpActivity::class.java)
            startActivity(back)
        }

        // code for forgot password
        myforgotpasswordLink.setOnClickListener {
            val next = Intent(this,ForgetPasswordActivity::class.java)
            startActivity(next)
        }

        // code for authentication
        myLoginBtn.setOnClickListener {
            LoginUser()
        }
    }

    private fun LoginUser(){
        //code to change data types to match
        val email = myemail.text.toString()
        val password = mypassword.text.toString()

        authenticate.signInWithEmailAndPassword(email,password).addOnCompleteListener(this) {
            if(it.isSuccessful){
                Toast.makeText(this,"Welcome, SignUp Successfully",Toast.LENGTH_SHORT).show()
                val nextpage = Intent(this,DashBoardActivity::class.java)
                startActivity(nextpage)
                finish()
            }
            else{
                Toast.makeText(this,"Failed, please try again",Toast.LENGTH_LONG).show()
            }
        }
    }
}
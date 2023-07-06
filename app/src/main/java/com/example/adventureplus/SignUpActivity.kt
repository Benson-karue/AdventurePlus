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

class SignUpActivity : AppCompatActivity() {

    lateinit var myemail : EditText
    lateinit var myphone :EditText
    lateinit var mypassword : EditText
    lateinit var myconfirmpass : EditText
    lateinit var mysignupbtn : Button
    lateinit var myloginlink: TextView
    private lateinit var authenticate : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        myemail = findViewById(R.id.editTextEmail_1)
        myphone = findViewById(R.id.editTextPhone_1)
        mypassword = findViewById(R.id.editTextPassword_1)
        myconfirmpass = findViewById(R.id.editTextConfirmPassword_1)
        mysignupbtn = findViewById(R.id.RegisterBtn)
        authenticate = Firebase.auth

        // code for SignUp Button
        myloginlink = findViewById(R.id.LoginLink)
        myloginlink.setOnClickListener {
            val nextpage  = Intent(this,LoginActivity::class.java)
            startActivity(nextpage)}

            // code for the signup forms

            mysignupbtn.setOnClickListener {
                RegisterForm()

        }
    }
    private fun RegisterForm (){
        val email = myemail.text.toString()
        val phone = myphone.text.toString()
        val password = mypassword.text.toString()
        val comfirmpassword = myconfirmpass.text.toString()

        if(email.isBlank() || password.isBlank() ||phone.isBlank() || comfirmpassword.isBlank()){
            Toast.makeText(this,"Please,fill all inputs ",Toast.LENGTH_LONG).show()
            return
        }
        else if(password != comfirmpassword){
            Toast.makeText(this,"Password don't match.", Toast.LENGTH_LONG).show()
            return
        }
        authenticate.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this,"Registered Successfully",Toast.LENGTH_LONG).show()
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)


            }
            else{
                Toast.makeText(this,"Sign up failed",Toast.LENGTH_LONG).show()

            }
        }

    }
}
package com.example.adventureplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {

    lateinit var forgetpassBtn: Button
    lateinit var myemail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        forgetpassBtn = findViewById(R.id.forgetPassButton)
        myemail = findViewById(R.id.forgetpassEmail)

        forgetpassBtn.setOnClickListener {
            val email: String = myemail.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this,"Please enter email address",Toast.LENGTH_LONG).show()
            }
            else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Email Successfully to reset your password",Toast.LENGTH_LONG).show()
                            finish()}
                        else {
                            Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_LONG).show()
                        }


                    }
            }
        }
    }
}
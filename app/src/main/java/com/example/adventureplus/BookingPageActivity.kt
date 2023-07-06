package com.example.adventureplus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.adventureplus.com.example.adventureplus.TravellerDataClass
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.NonCancellable

class BookingPageActivity : AppCompatActivity() {

    lateinit var bookingName: EditText
    lateinit var bookingPhone: EditText
    lateinit var bookingPersons: EditText
    lateinit var submitBtn: Button
    lateinit var LogOutBtn: ImageView
    lateinit var backpageBtn: ImageView

    private lateinit var databaseRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_page)

        bookingName = findViewById(R.id.BookingNameET)
        bookingPhone = findViewById(R.id.BookingPhoneTV)
        bookingPersons = findViewById(R.id.BookingPersonsET)
        submitBtn = findViewById(R.id.SubmitBtn)
        LogOutBtn = findViewById(R.id.LogOutBtn)
        backpageBtn = findViewById(R.id.backpagearrow)

        databaseRef = FirebaseDatabase.getInstance().getReference()

        // Back Page Arrow code
        backpageBtn.setOnClickListener {
            val nextpage = Intent(this,HomeActivity::class.java)
            startActivity(nextpage)
        }

        // Log Out Alert message
        LogOutBtn.setOnClickListener {
            Toast.makeText(applicationContext,"Thanks for visiting AdventurePlus+",Toast.LENGTH_LONG).show()
            val box = AlertDialog.Builder(this)
            box.setMessage("Do you want to close this app?")
            box.setPositiveButton("Confirm", DialogInterface.OnClickListener { dialog, id ->
                val logout = Intent(this,LoginActivity::class.java)
                startActivity(logout)
                finish()
            })

            box.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id -> NonCancellable.cancel() })

            val alert= box.create()
            alert.setTitle("AdventurePlus+")
            alert.show()
        }


        // Booking Form code

        submitBtn.setOnClickListener {
            saveTouristData()
        }
    }

    private  fun saveTouristData(){
        val  Fullname =  bookingName.text.toString()
        val contact = bookingPhone.text.toString()
        val persons = bookingPersons.text.toString()

        if(Fullname.isEmpty() || contact.isEmpty() || persons.isEmpty()){
            Toast.makeText(this,"Please fill all fields",Toast.LENGTH_LONG).show()
        }
        val travellerID = databaseRef.push().key!!

        val traveller = TravellerDataClass(travellerID, Fullname, contact, persons)

        databaseRef.child(travellerID).setValue(traveller)
            .addOnCompleteListener {
                Toast.makeText(this,"Booked Successfully,Thanks",Toast.LENGTH_LONG).show()
                bookingName.text.clear()
                bookingPhone.text.clear()
                bookingPersons.text.clear()
            }
            .addOnFailureListener {
                Toast.makeText(this,"Error, Please try again",Toast.LENGTH_LONG ).show()
            }

    }
}

/* package com.example.adventureplus


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePageActivity : AppCompatActivity() {

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var BookingBtn:Button
    lateinit var HomepageRV: RecyclerView
    lateinit var searchBarView :androidx.appcompat.widget.SearchView
    lateinit var TravelRVAdapter: TravelRVAdapter
    lateinit var officeLocation: ImageView
    lateinit var LocationsList: ArrayList<TravelRVModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // code for office location
        officeLocation = findViewById(R.id.btnLocation)


        // code to link Btn button to booking activity
        BookingBtn = findViewById(R.id.BookingBtn)
        BookingBtn.setOnClickListener {
            val nextpage =  Intent(this, BookingPageActivity::class.java)
            startActivity(nextpage)
        }


        searchBarView = findViewById(R.id.SearchBarView)

        HomepageRV = findViewById(R.id.rv_locationCard)
        HomepageRV.layoutManager = LinearLayoutManager(this)

        // on below line we are initializing our views with their ids.
        HomepageRV = findViewById(R.id.rv_locationCard)

        // on below line we are initializing our list
        LocationsList = ArrayList()

        // on below line we are initializing our adapter
        TravelRVAdapter = TravelRVAdapter(LocationsList)

        // on below line we are setting adapter to our recycler view.
        HomepageRV.adapter = TravelRVAdapter


        // on below line we are adding data to our list
        LocationsList.add(TravelRVModal("Zanzibar Summer Tours","800","Discover Zanzibar's best beaches with its spectacular sunsets, palm-fringed beaches, turquoise waters & colourful coral reefs. Discover Zanzibar's best beaches with its spectacular sunsets, palm-fringed beaches, turquoise waters & colourful coral reefs",R.drawable.lamuisland))
        LocationsList.add(TravelRVModal("Zanzibar Summer Tours","800","Discover Zanzibar's best beaches with its spectacular sunsets, palm-fringed beaches, turquoise waters & colourful coral reefs. Discover Zanzibar's best beaches with its spectacular sunsets, palm-fringed beaches, turquoise waters & colourful coral reefs",R.drawable.lamuisland))
        LocationsList.add(TravelRVModal("Zanzibar Summer Tours","800","Discover Zanzibar's best beaches with its spectacular sunsets, palm-fringed beaches, turquoise waters & colourful coral reefs. Discover Zanzibar's best beaches with its spectacular sunsets, palm-fringed beaches, turquoise waters & colourful coral reefs",R.drawable.lamuisland))
      /*  LocationsList.add(TravelRVModal("Maasai mara Game Drive",R.drawable.masaaimara))
        LocationsList.add(TravelRVModal("Diani, Kenya", R.drawable.dianiwasini))
        LocationsList.add(TravelRVModal("Mt OLolokwe,Samburu", R.drawable.mtlongonot))
        LocationsList.add(TravelRVModal("Nakuru National Park", R.drawable.lakenakuru))
        LocationsList.add(TravelRVModal("Rusinga Island,Kisumu", R.drawable.rusingaisland))

        LocationsList.add(TravelRVModal("Mt Kenya Park", R.drawable.mtkenya))
        LocationsList.add(TravelRVModal("Serengeti, Tz", R.drawable.masaaimara))
        LocationsList.add(TravelRVModal("Ol Pajeta, Laikipia", R.drawable.masaaimara))
        LocationsList.add(TravelRVModal("Mt Longonot", R.drawable.mtlongonot))
        LocationsList.add(TravelRVModal("Old Lamu Island", R.drawable.lamuisland))  */

    }
}*/


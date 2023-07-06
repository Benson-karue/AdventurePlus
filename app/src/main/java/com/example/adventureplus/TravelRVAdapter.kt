/*  package com.example.adventureplus

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TravelRVAdapter(
    // on below line we are passing variables as Locations list and context
    private var LocationsList: ArrayList<TravelRVModal>,
) : RecyclerView.Adapter<TravelRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TravelRVAdapter.CourseViewHolder {
        // this method is use to inflate the layout file

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.homepage_rv_item,
            parent, false
        )


        return CourseViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TravelRVAdapter.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.LocationNameTV.text = LocationsList.get(position).LocationName
        holder.LocationPiciV.setImageResource(LocationsList.get(position).LocationImg)
        holder.LocationCostTV.text= LocationsList.get(position).Cost
        holder.LocationDescTV.text = LocationsList.get(position).LocationInfo
    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return LocationsList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val LocationNameTV: TextView = itemView.findViewById(R.id.tv_location)
        val LocationPiciV: ImageView = itemView.findViewById(R.id.iv_Locationpic)
        val LocationCostTV:TextView= itemView.findViewById(R.id.CostTV)
        val LocationDescTV:TextView= itemView.findViewById(R.id.tv_Locdescription)
        val BookingBtn:Button =itemView.findViewById(R.id.BookingBtn)


    }

}   */

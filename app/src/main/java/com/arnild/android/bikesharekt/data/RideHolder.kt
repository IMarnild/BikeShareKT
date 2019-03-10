package com.arnild.android.bikesharekt.data

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.arnild.android.bikesharekt.R

class RideHolder(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.adapter_array_ride, parent, false)) {

    lateinit var ride: Ride

    private var bike: TextView = itemView.findViewById(R.id.what_bike_ride)
    private val start: TextView = itemView.findViewById(R.id.start_ride)
    private val end: TextView = itemView.findViewById(R.id.end_ride)

    fun bind(clickListener: (Ride) -> Unit, ride: Ride) {
        this.ride = ride
        this.bike.text = ride.bikeName
        this.start.text = ride.startRide
        this.end.text = ride.endRide
        itemView.setOnClickListener { clickListener(ride) }
    }
}

package com.arnild.android.bikesharekt.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.arnild.android.bikesharekt.data.Ride
import com.arnild.android.bikesharekt.data.RideHolder

class RideArrayAdapter(val rides: List<Ride>) : RecyclerView.Adapter<RideHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RideHolder {
        val inflater = LayoutInflater.from(p0.context)
        return RideHolder(inflater, p0)
    }

    override fun onBindViewHolder(p0: RideHolder, p1: Int) {
        val ride: Ride = this.rides[p1]
        p0.bind(ride)
    }

    override fun getItemCount(): Int = this.rides.size
}

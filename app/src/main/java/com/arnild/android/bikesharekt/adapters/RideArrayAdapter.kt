package com.arnild.android.bikesharekt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.data.Ride

class RideArrayAdapter(context: Context, objects: List<Ride>) : ArrayAdapter<Ride>(context,
    R.layout.adapter_array_ride, objects) {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.adapter_array_ride, parent, false)

        var bike = getItem(position).bikeName
        var start = getItem(position).startRide
        var end = getItem(position).endRide

        val bikeView = rowView.findViewById(R.id.what_bike_ride) as TextView
        val startView = rowView.findViewById(R.id.start_ride) as TextView
        val endView = rowView.findViewById(R.id.end_ride) as TextView

        bikeView.text = bike
        startView.text = start
        endView.text = end

        return rowView
    }
}
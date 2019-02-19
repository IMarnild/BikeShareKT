package com.arnild.android.bikesharekt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.data.Ride
import com.arnild.android.bikesharekt.data.RideHolder

class RideArrayAdapter(context: Context, objects: List<Ride>) : ArrayAdapter<Ride>(context,
    R.layout.adapter_array_ride, objects) {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val holder: RideHolder
        var cView = convertView

        if (convertView == null) {
            cView = inflater.inflate(R.layout.adapter_array_ride, parent, false)

            holder = RideHolder(
                cView.findViewById(R.id.what_bike_ride),
                cView.findViewById(R.id.start_ride),
                cView.findViewById(R.id.end_ride)
            )
            cView.tag = holder
        }
        else {
            holder = cView!!.tag as RideHolder
        }

        val bike = this.getItem(position)!!.bikeName
        val start = this.getItem(position)!!.startRide
        val end = this.getItem(position)!!.endRide

        holder.bike.text = bike
        holder.start.text = start
        holder.end.text = end

        return cView!!
    }
}
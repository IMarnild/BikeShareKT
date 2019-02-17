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

    private data class ViewHolder @JvmOverloads constructor(
        val bike: TextView,
        val start: TextView,
        val end: TextView
    )

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val holder: ViewHolder
        var cView = convertView

        if (convertView == null) {
            cView = inflater.inflate(R.layout.adapter_array_ride, parent, false)

            holder = ViewHolder(
                cView.findViewById(R.id.what_bike_ride),
                cView.findViewById(R.id.start_ride),
                cView.findViewById(R.id.end_ride)
            )
            cView.tag = holder
        }
        else {
            holder = cView!!.tag as ViewHolder
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
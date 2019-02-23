package com.arnild.android.bikesharekt.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.activities.EndRideActivity
import com.arnild.android.bikesharekt.activities.StartRideActivity


class BikeShareFragment : Fragment() {

    private lateinit var listView: ListView
    private val LIST_RIDE_VISIBILITY: String = "rideList"
    private var isRideListVisible: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bike_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.listView = view.findViewById(R.id.list_view_ride)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.isRideListVisible = savedInstanceState?.getBoolean(LIST_RIDE_VISIBILITY, false) ?: false
        this.listView.visibility =  if (isRideListVisible) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState!!.putBoolean(LIST_RIDE_VISIBILITY, this.isRideListVisible)
    }

    fun startAddRide(view: View) {
        val intent = Intent(view.context, StartRideActivity::class.java)
        this.startActivity(intent)
    }

    fun startEndRide(view: View) {
        val intent = Intent(view.context, EndRideActivity::class.java)
        this.startActivity(intent)
    }

    fun showRides(view: View) {
        if (this.listView.visibility == View.GONE) {
            this.listView.visibility = View.VISIBLE
            this.isRideListVisible = true
        }
        else {
            this.listView.visibility = View.GONE
            this.isRideListVisible = false
        }
    }

}

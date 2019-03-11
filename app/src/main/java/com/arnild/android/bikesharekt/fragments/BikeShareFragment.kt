package com.arnild.android.bikesharekt.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.activities.EndRideActivity
import com.arnild.android.bikesharekt.activities.RideInfoActivity
import com.arnild.android.bikesharekt.activities.StartRideActivity
import com.arnild.android.bikesharekt.adapters.RideArrayAdapter
import com.arnild.android.bikesharekt.data.Ride
import com.arnild.android.bikesharekt.data.RideDb

class BikeShareFragment : Fragment() {

    private val LIST_RIDE_VISIBILITY: String = "rideList"
    private var isRideListVisible: Boolean = false
    private lateinit var listView: RecyclerView
    private lateinit var viewAdapter: RideArrayAdapter
    private lateinit var addRide: Button
    private lateinit var endRide: Button
    private lateinit var listRides: Button
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bike_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initVariables(view)
        this.setButtonListeners()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.loadPreferences()
        this.listView.visibility =  if (isRideListVisible) View.VISIBLE else View.GONE
    }

    override fun onStart() {
        super.onStart()
        // TODO: find out how to auto-update recyclerViewAdapter
        if (this.isRideListVisible) {
            //refresh list
            this.toggleRideList()
            this.toggleRideList()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(LIST_RIDE_VISIBILITY, this.isRideListVisible)
    }

    private fun initVariables(view: View) {
        this.preferences = activity!!.getPreferences(Context.MODE_PRIVATE)
        this.addRide = view.findViewById(R.id.add_button)
        this.endRide = view.findViewById(R.id.end_button)
        this.listRides = view.findViewById(R.id.list_button)
        this.viewManager = LinearLayoutManager(activity)
        this.viewAdapter = RideArrayAdapter(RideDb.getAll()) { ride : Ride -> onListItemClicked(ride)}
        this.listView = view.findViewById<RecyclerView>(R.id.recycle_view_ride).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun setButtonListeners() {
        this.addRide.setOnClickListener {
            val intent = Intent(activity, StartRideActivity::class.java)
            this.startActivity(intent) }

        this.endRide.setOnClickListener {
            val intent = Intent(activity, EndRideActivity::class.java)
            this.startActivity(intent) }

        this.listRides.setOnClickListener { this.toggleRideList() }
    }

    private fun toggleRideList() {
        if (this.listView.visibility == View.GONE) {
            this.listView.visibility = View.VISIBLE
            this.isRideListVisible = true
        }
        else {
            this.listView.visibility = View.GONE
            this.isRideListVisible = false
        }
        this.savePreferences()
    }

    private fun onListItemClicked(rideItem: Ride) {
        println("clicked" + rideItem.bikeName)

        var intent = Intent(activity, RideInfoActivity::class.java)

        intent.putExtra("Ride_NAME", rideItem.bikeName)
        intent.putExtra("RIDE_START", rideItem.startRide)
        intent.putExtra("RIDE_END", rideItem.endRide)
        intent.putExtra("RIDE_START_TIME", rideItem.startRideTime)
        intent.putExtra("RIDE_END_TIME", rideItem.endRideTime)

        this.startActivity(intent)
    }

    private fun savePreferences() {
        var editor = this.preferences.edit()
        editor.putBoolean(LIST_RIDE_VISIBILITY, this.isRideListVisible)
        editor.apply()
    }

    private fun loadPreferences() {
        this.isRideListVisible = this.preferences.getBoolean(LIST_RIDE_VISIBILITY, false)
    }

}

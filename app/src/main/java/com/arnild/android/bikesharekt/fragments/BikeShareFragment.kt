package com.arnild.android.bikesharekt.fragments

import android.content.Intent
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
import com.arnild.android.bikesharekt.activities.StartRideActivity
import com.arnild.android.bikesharekt.adapters.RideArrayAdapter
import com.arnild.android.bikesharekt.data.RideDb

class BikeShareFragment : Fragment() {

    private lateinit var listView: RecyclerView
    private lateinit var viewAdapter: RideArrayAdapter
    private lateinit var addRide: Button
    private lateinit var endRide: Button
    private lateinit var listRides: Button
    private val LIST_RIDE_VISIBILITY: String = "rideList"
    private var isRideListVisible: Boolean = false
    private lateinit var viewManager: RecyclerView.LayoutManager

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
        this.isRideListVisible = savedInstanceState?.getBoolean(LIST_RIDE_VISIBILITY, false) ?: false
        this.listView.visibility =  if (isRideListVisible) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(LIST_RIDE_VISIBILITY, this.isRideListVisible)
    }

    private fun initVariables(view: View) {
        this.addRide = view.findViewById(R.id.add_button)
        this.endRide = view.findViewById(R.id.end_button)
        this.listRides = view.findViewById(R.id.list_button)
        this.viewManager = LinearLayoutManager(activity)
        this.viewAdapter = RideArrayAdapter(RideDb.getAll())
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

        this.listRides.setOnClickListener { this.showRides() }
    }

    private fun showRides() {
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

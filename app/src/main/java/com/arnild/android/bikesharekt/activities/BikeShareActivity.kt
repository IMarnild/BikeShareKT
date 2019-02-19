package com.arnild.android.bikesharekt.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.arnild.android.bikesharekt.adapters.RideArrayAdapter
import com.arnild.android.bikesharekt.data.RideDb
import com.arnild.android.bikesharekt.R

class BikeShareActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val LIST_RIDE_VISIBILITY: String = "rideList"
    private var isRideListVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_share)
        this.listView = findViewById(R.id.list_view_ride)
        this.isRideListVisible = savedInstanceState?.getBoolean(LIST_RIDE_VISIBILITY, false) ?: false
        this.listView.visibility =  if (isRideListVisible) View.VISIBLE else View.GONE
    }

    override fun onStart() {
        super.onStart()
        val rideArrayAdapter = RideArrayAdapter(this, RideDb.getAll())
        this.listView.adapter = rideArrayAdapter
    }

    fun startAddRide(view: View) {
        val intent = Intent(this, StartRideActivity::class.java)
        this.startActivity(intent)
    }

    fun startEndRide(view: View) {
        val intent = Intent(this, EndRideActivity::class.java)
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putBoolean(LIST_RIDE_VISIBILITY, this.isRideListVisible)
    }
}


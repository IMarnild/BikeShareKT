package com.arnild.android.bikesharekt.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.data.RideForm

class EndRideActivity : AppCompatActivity() {

    private lateinit var rideForm: RideForm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_ride)
        this.rideForm = RideForm(this)
    }

    fun endRide(view: View) {
        val bike = rideForm.getWhat()
        val where = rideForm.getWhere()

        rideForm.submit(bike, "n/a", where)
    }
}
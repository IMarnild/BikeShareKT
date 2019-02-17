package com.arnild.android.bikesharekt.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.data.RideDb
import com.arnild.android.bikesharekt.data.RideForm

class StartRideActivity : AppCompatActivity() {

    private lateinit var rideForm: RideForm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_ride)
        this.rideForm = RideForm(this)
    }

    fun addRide(view: View) {
        val bike = rideForm.getWhat()
        val where = rideForm.getWhere()

        rideForm.submit(bike, where, "n/a")
        RideDb.add(bike, where, "n/a")
    }
}

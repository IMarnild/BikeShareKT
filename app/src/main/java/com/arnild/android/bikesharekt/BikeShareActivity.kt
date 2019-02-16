package com.arnild.android.bikesharekt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BikeShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_share)

        val startRide: Button = findViewById(R.id.start_ride)

        startRide.setOnClickListener {
            val intent = Intent(this, StartRideActivity::class.java)
            this.startActivity(intent)
        }
    }
}


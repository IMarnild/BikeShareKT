package com.arnild.android.bikesharekt.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.arnild.android.bikesharekt.R

class RideInfoActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var start: TextView
    private lateinit var end: TextView
    private lateinit var startTime: TextView
    private lateinit var endTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ride_info)

        this.name = findViewById(R.id.what_bike_ride)
        this.start = findViewById(R.id.start_ride)
        this.end = findViewById(R.id.end_ride)
        this.startTime = findViewById(R.id.start_time_ride)
        this.endTime = findViewById(R.id.end_time_ride)

        this.setInfo()
    }

    private fun setInfo() {
        val extras = this.intent.extras
        if (extras != null) {
            this.name.text = extras.getString("Ride_NAME")
            this.start.text = extras.getString("RIDE_START")
            this.end.text = extras.getString("RIDE_END")
            this.startTime.text = extras.getString("RIDE_START_TIME")
            this.endTime.text = extras.getString("RIDE_END_TIME")
        }
    }
}

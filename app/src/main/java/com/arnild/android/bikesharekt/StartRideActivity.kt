package com.arnild.android.bikesharekt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class StartRideActivity : AppCompatActivity() {

    private lateinit var lastAdded: TextView
    private lateinit var last: Ride

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_share)

        lastAdded = findViewById(R.id.last_thing)
        if (lastAdded.text.isNotBlank()) updateUI()

        val addRide: Button = findViewById(R.id.add_button)
        val newWhat: TextView = findViewById(R.id.what_text)
        val newWhere: TextView = findViewById(R.id.where_text)

        addRide.setOnClickListener {
            if (!isBlank(newWhat) && !isBlank(newWhere)) {
                last = Ride(getInput(newWhat), getInput(newWhere))
                updateUI()
            }
        }
    }
    private fun updateUI() {
        lastAdded.text = last.toString()
    }

    private fun isBlank(textView: TextView): Boolean {
        return textView.text.toString().isBlank()
    }

    private fun getInput(textView: TextView): String {
        return textView.text.toString().trim()
    }
}

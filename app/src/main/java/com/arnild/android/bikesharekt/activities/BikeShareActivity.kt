package com.arnild.android.bikesharekt.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.fragments.BikeShareFragment

class BikeShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_share)

        if (this.findViewById<FrameLayout>(R.id.fragment_container) != null) {

            if (savedInstanceState != null) return

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, BikeShareFragment())
                .commit()
        }
    }
}


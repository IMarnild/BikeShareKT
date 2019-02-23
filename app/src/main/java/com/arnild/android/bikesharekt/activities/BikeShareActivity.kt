package com.arnild.android.bikesharekt.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arnild.android.bikesharekt.R
import com.arnild.android.bikesharekt.fragments.BikeShareFragment

class BikeShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_share)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, BikeShareFragment())
            .commit()
    }
}


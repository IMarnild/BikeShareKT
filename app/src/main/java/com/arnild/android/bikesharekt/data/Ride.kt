package com.arnild.android.bikesharekt.data

data class Ride(val bikeName: String, val startRide: String, val endRide: String) {

    override fun toString(): String {
        return "$bikeName , $startRide , $endRide"
    }
}


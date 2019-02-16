package com.arnild.android.bikesharekt

data class Ride(val bikeName: String, val startRide: String) {

    override fun toString(): String {
        return "$bikeName , $startRide"
    }
}


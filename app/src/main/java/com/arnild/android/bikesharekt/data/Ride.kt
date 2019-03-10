package com.arnild.android.bikesharekt.data

data class Ride (
    val bikeName: String,
    val startRide: String,
    val endRide: String,
    val startRideTime: String,
    val endRideTime: String) {

    override fun toString(): String {
        return "$bikeName , $startRide , $endRide, $startRideTime, $endRideTime"
    }
}


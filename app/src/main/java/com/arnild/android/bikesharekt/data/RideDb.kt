package com.arnild.android.bikesharekt.data

object RideDb {
    private val allRides: ArrayList<Ride> = ArrayList()

    fun getAll(): MutableList<Ride> {
        return allRides
    }

    fun add(bike: String, start: String, end: String) {
        allRides.add(Ride(bike, start, end))
    }

    init {
        allRides.add(Ride("Chuck Norris bike", "ITU", "Fields"))
        allRides.add(Ride("Bruce Lee bike", "DR2", "Fields"))
        allRides.add(Ride("Arnold S bike", "KU", "Fields"))
    }
}
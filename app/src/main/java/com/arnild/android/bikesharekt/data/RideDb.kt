package com.arnild.android.bikesharekt.data

import java.util.*

object RideDb {
    private val allRides: MutableList<Ride> = ArrayList()

    fun getAll(): MutableList<Ride> {
        return allRides
    }

    fun add(bike: String, start: String, end: String, startTime: String, endTime: String) {
        allRides.add(Ride(bike, start, end, startTime, endTime))
    }

    init {
        allRides.add(Ride("Chuck Norris bike", "ITU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Bruce Lee bike", "DR2", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Arnold S bike", "KU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Chuck Norris bike2", "ITU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Bruce Lee bike2", "DR2", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Arnold S bike2", "KU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Chuck Norris bike3", "ITU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Bruce Lee bike3", "DR2", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Arnold S bike3", "KU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Chuck Norris bike4", "ITU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Bruce Lee bike4", "DR2", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Arnold S bike4", "KU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Chuck Norris bike5", "ITU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Bruce Lee bike5", "DR2", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
        allRides.add(Ride("Arnold S bike5", "KU", "Fields", "01/01/2019 00:00:00", "01/01/2019 00:00:00"))
    }
}
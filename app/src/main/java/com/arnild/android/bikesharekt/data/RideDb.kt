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
        allRides.add(Ride("Chuck Norris bike2", "ITU", "Fields"))
        allRides.add(Ride("Bruce Lee bike2", "DR2", "Fields"))
        allRides.add(Ride("Arnold S bike2", "KU", "Fields"))
        allRides.add(Ride("Chuck Norris bike3", "ITU", "Fields"))
        allRides.add(Ride("Bruce Lee bike3", "DR2", "Fields"))
        allRides.add(Ride("Arnold S bike3", "KU", "Fields"))
        allRides.add(Ride("Chuck Norris bike4", "ITU", "Fields"))
        allRides.add(Ride("Bruce Lee bike4", "DR2", "Fields"))
        allRides.add(Ride("Arnold S bike4", "KU", "Fields"))
        allRides.add(Ride("Chuck Norris bike5", "ITU", "Fields"))
        allRides.add(Ride("Bruce Lee bike5", "DR2", "Fields"))
        allRides.add(Ride("Arnold S bike5", "KU", "Fields"))
    }
}
package com.arnild.android.bikesharekt.data

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import com.arnild.android.bikesharekt.R

class RideForm {

    private lateinit var last: Ride

    private var lastAdded: TextView
    private var newWhat: TextView
    private var newWhere: TextView

    constructor(activity: Activity) {
        this.lastAdded = activity.findViewById(R.id.last_thing)
        if (this.lastAdded.text.isNotBlank()) updateUI()
        this.newWhat = activity.findViewById(R.id.what_text)
        this.newWhere = activity.findViewById(R.id.where_text)
    }

    private fun updateUI() {
        this.lastAdded.text = last.toString()
        this.newWhat.text = ""
        this.newWhere.text = ""
        this.newWhere.requestFocus()
    }

    private fun isBlank(textView: TextView): Boolean {
        return textView.text.toString().isBlank()
    }

    fun submit(bike: String, start: String, end: String) {
        if (!isBlank(this.newWhat) && !isBlank(this.newWhere)) {
            this.last = Ride(bike, start, end)
            updateUI()
        }
    }

    fun getWhat(): String {
        return this.newWhat.text.toString().trim()
    }

    fun getWhere(): String {
        return this.newWhere.text.toString().trim()
    }
}
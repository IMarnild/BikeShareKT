package com.arnild.android.bikesharekt.data

import android.app.Activity
import android.widget.TextView
import com.arnild.android.bikesharekt.R
import java.text.SimpleDateFormat
import java.util.*

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

    fun submit(bike: String, start: String, end: String) {
        if (this.confirmUserInput()) {
            this.last = Ride(bike, start, end, this.getDate(), this.getDate())
            RideDb.add(bike,start,end, this.getDate(), this.getDate())
            updateUI()
        }
    }

    fun getWhat(): String {
        return this.newWhat.text.toString().trim()
    }

    fun getWhere(): String {
        return this.newWhere.text.toString().trim()
    }

    private fun getDate(): String {
        val date = Calendar.getInstance().time
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.GERMAN)
        return simpleDateFormat.format(date)
    }

    private fun confirmUserInput(): Boolean {
        return !isBlank(this.newWhat) && !isBlank(this.newWhere)
    }

    private fun isBlank(textView: TextView): Boolean {
        return textView.text.toString().isBlank()
    }
}
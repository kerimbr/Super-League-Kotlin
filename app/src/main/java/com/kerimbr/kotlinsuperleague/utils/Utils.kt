package com.kerimbr.kotlinsuperleague.utils

import com.kerimbr.kotlinsuperleague.data.dto.fixture.FixtureResponse
import java.util.Calendar
import java.util.Date

class Utils {
    companion object {
        private fun getFixtureCalendar(fixture: FixtureResponse): Calendar {
            val timestamp: Long = fixture.fixture.timestamp.toLong() * 1000
            val date =  Date(timestamp)

            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar
        }


        fun getFixtureHour(fixture: FixtureResponse): String {
            val calendar = getFixtureCalendar(fixture)
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val hourString = if (hour < 10) "0$hour" else hour.toString()
            val minute = calendar.get(Calendar.MINUTE)
            val minuteString = if (minute < 10) "0$minute" else minute.toString()
            return "$hourString:$minuteString"
        }

        fun getFixtureDateStr(fixture: FixtureResponse): String {
            val calendar = getFixtureCalendar(fixture)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val dayString = if (day < 10) "0$day" else day.toString()
            val month = calendar.get(Calendar.MONTH) + 1
            val monthString = if (month < 10) "0$month" else month.toString()
            val year = calendar.get(Calendar.YEAR)
            return "$dayString/$monthString/$year"
        }

    }
}
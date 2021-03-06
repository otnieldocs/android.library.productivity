package com.otnieldocs.productivity.extensions

import java.util.*

fun Date.remainingDays(offset: Long): Int {
    val diff = this.time - offset
    return (diff / DAY_TO_MILLIS).toInt()
}

fun Date.remainingDays(offset: Date): Int {
    val diff = this.time - offset.time
    return (diff / DAY_TO_MILLIS).toInt()
}

const val SECOND_TO_MILLIS = 1000
const val MINUTE_TO_SECOND = 60
const val HOUR_TO_MINUTE = 60
const val DAY_TO_HOUR = 24
const val MINUTE_TO_MILLIS = MINUTE_TO_SECOND * SECOND_TO_MILLIS
const val HOUR_TO_MILLIS = HOUR_TO_MINUTE * MINUTE_TO_MILLIS
const val DAY_TO_MILLIS = DAY_TO_HOUR * HOUR_TO_MILLIS
package com.otnieldocs.productivity.extensions

import com.otnieldocs.productivity.model.Diff
import java.util.*

fun Date.diffMillis(offset: Long): Long = this.time - offset

fun Date.remainingDays(offset: Long): Int {
    val diff = diffMillis(offset)
    return (diff / DAY_TO_MILLIS).toInt()
}

fun Date.remainingDays(offset: Date): Int {
    val diff = diffMillis(offset.time)
    return (diff / DAY_TO_MILLIS).toInt()
}

fun Date.remainingHours(offset: Long): Double {
    val diff = diffMillis(offset)
    return (diff.toDouble() / HOUR_TO_MILLIS)
}

fun Date.remainingHours(offset: Date): Double {
    val diff = diffMillis(offset.time)
    return (diff.toDouble() / HOUR_TO_MILLIS)
}

fun Date.remainingMinutes(offset: Long): Double {
    val diff = diffMillis(offset)
    return (diff.toDouble() / MINUTE_TO_MILLIS)
}

fun Date.remainingMinutes(offset: Date): Double {
    val diff = diffMillis(offset.time)
    return (diff.toDouble() / MINUTE_TO_MILLIS)
}

fun Date.remaining(offset: Long): Diff {
    val diff = diffMillis(offset)

    return when {
        diff / SECOND_TO_MILLIS < 1 -> Diff(diff.toDouble(), DIFF_IN_SECOND)

        diff / MINUTE_TO_MILLIS < 1 -> Diff(diff.toDouble(), DIFF_IN_MINUTE)

        diff / HOUR_TO_MINUTE < 1 -> Diff(diff.toDouble(), DIFF_IN_HOUR)

        diff / DAY_TO_MILLIS < 1 -> Diff(diff.toDouble(), DIFF_IN_DAY)

        else -> Diff(diff.toDouble(), DIFF_IN_MILLIS)
    }
}

fun Date.remaining(offset: Date): Diff {
    val diff = diffMillis(offset.time)

    return when {
        diff / SECOND_TO_MILLIS < 1 -> Diff(diff.toDouble(), DIFF_IN_SECOND)

        diff / MINUTE_TO_MILLIS < 1 -> Diff(diff.toDouble(), DIFF_IN_MINUTE)

        diff / HOUR_TO_MINUTE < 1 -> Diff(diff.toDouble(), DIFF_IN_HOUR)

        diff / DAY_TO_MILLIS < 1 -> Diff(diff.toDouble(), DIFF_IN_DAY)

        else -> Diff(diff.toDouble(), DIFF_IN_MILLIS)
    }
}

const val DIFF_IN_MILLIS = 0
const val DIFF_IN_SECOND = 1
const val DIFF_IN_MINUTE = 2
const val DIFF_IN_HOUR = 3
const val DIFF_IN_DAY = 4
const val SECOND_TO_MILLIS = 1000
const val MINUTE_TO_SECOND = 60
const val HOUR_TO_MINUTE = 60
const val DAY_TO_HOUR = 24
const val MINUTE_TO_MILLIS = MINUTE_TO_SECOND * SECOND_TO_MILLIS
const val HOUR_TO_MILLIS = HOUR_TO_MINUTE * MINUTE_TO_MILLIS
const val DAY_TO_MILLIS = DAY_TO_HOUR * HOUR_TO_MILLIS
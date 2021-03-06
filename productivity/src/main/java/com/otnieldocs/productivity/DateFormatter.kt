package com.otnieldocs.productivity

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    fun parseISO8601(dateString: String): Date? {
        return try {
            SimpleDateFormat(DateConstant.RFC_3339_V1, Locale.getDefault()).parse(dateString)
        } catch (e: ParseException) {
            SimpleDateFormat(DateConstant.RFC_3339_V2, Locale.getDefault()).parse(dateString)
        }
    }
}

object DateConstant {
    const val RFC_3339_V1 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    const val RFC_3339_V2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
}

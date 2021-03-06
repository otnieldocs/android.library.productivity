package com.otnieldocs.productivity.formatters

import com.otnieldocs.productivity.extensions.orBeginning
import com.otnieldocs.productivity.formatters.DateConstant.TIME_ZONE_GMT
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    private fun formatter(
        pattern: String,
        locale: Locale
    ) = SimpleDateFormat(pattern, locale)

    private fun formatter(
        pattern: String,
        locale: Locale,
        timeZone: TimeZone
    ) = formatter(pattern, locale)
        .apply { setTimeZone(timeZone) }

    fun parseISO8601(dateString: String): Date? {
        return try {
            formatter(
                DateConstant.RFC_3339_V1,
                Locale.getDefault()
            ).parse(dateString)
        } catch (e: ParseException) {
            formatter(
                DateConstant.RFC_3339_V2,
                Locale.getDefault()
            ).parse(dateString)
        }
    }

    fun parseISO8601(dateString: String, timeZone: TimeZone): Date? {
        return try {
            formatter(
                DateConstant.RFC_3339_V1,
                Locale.getDefault(),
                timeZone
            ).parse(dateString)
        } catch (e: ParseException) {
            formatter(
                DateConstant.RFC_3339_V2,
                Locale.getDefault(),
                timeZone
            ).parse(dateString)
        }
    }

    fun parseISO8601(dateString: String, locale: Locale, timeZone: TimeZone): Date? {
        return try {
            formatter(
                DateConstant.RFC_3339_V1,
                locale,
                timeZone
            ).parse(dateString)
        } catch (e: ParseException) {
            formatter(
                DateConstant.RFC_3339_V2,
                Locale.getDefault(),
                timeZone
            ).parse(dateString)
        }
    }

    @Throws(ParseException::class)
    fun parseTo(dateString: String, pattern: String): String {
        val date = parseISO8601(dateString, TimeZone.getTimeZone(TIME_ZONE_GMT))
        return formatter(pattern, Locale.getDefault()).format(date.orBeginning())
    }

    @Throws(ParseException::class)
    fun parseTo(dateString: String, timeZone: TimeZone, pattern: String): String {
        val date = parseISO8601(dateString, timeZone)
        return formatter(pattern, Locale.getDefault()).format(date.orBeginning())
    }
}

object DateConstant {
    const val TIME_ZONE_GMT = "GMT"
    const val RFC_3339_V1 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    const val RFC_3339_V2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
}

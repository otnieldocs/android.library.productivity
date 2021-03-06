package com.otnieldocs.productivity

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.otnieldocs.productivity.date.DateConstant.TIME_ZONE_GMT
import com.otnieldocs.productivity.common.orZero
import com.otnieldocs.productivity.date.DateFormatter
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class DateFormatterInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.otnieldocs.productivity.test", appContext.packageName)
    }

    @Test
    fun testTimeZoneGmtConversion() {
        val timeZone = TimeZone.getTimeZone(TIME_ZONE_GMT)
        val dateString = "2021-03-05T8:00:00Z"
        val actual = DateFormatter.parseISO8601(dateString, timeZone)?.time.orZero().toDouble()
        val expected = Calendar.getInstance().apply {
            set(2021, 2, 5, 15, 0, 0)
        }.time.time.toDouble()

        Assert.assertEquals(expected, actual, 1000.0)
    }

    @Test
    fun testTimeZoneGmtLocaleConversion() {
        val timeZone = TimeZone.getTimeZone(TIME_ZONE_GMT)
        val dateString = "2021-03-05T8:00:00Z"
        val actual = DateFormatter.parseISO8601(dateString, Locale.US, timeZone)?.time.orZero().toDouble()
        val expected = Calendar.getInstance().apply {
            set(2021, 2, 5, 15, 0, 0)
        }.time.time.toDouble()

        Assert.assertEquals(expected, actual, 1000.0)
    }
}
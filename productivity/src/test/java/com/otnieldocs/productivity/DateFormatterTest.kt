package com.otnieldocs.productivity

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class DateFormatterTest {
    @Before
    fun setUp() {}

    // RFC_3339_V1 type1 yyyy-MM-dd'T'H:mm:ss'Z'
    @Test
    fun `test format RFC_3339_V1 type 1 to Date`() {
        val dateString = "2021-03-05T8:00:00Z"
        val actual = DateFormatter.parseISO8601(dateString)?.time.orZero().toDouble()/1000
        val expected = Calendar.getInstance().apply {
            set(2021, 2, 5, 8, 0, 0)
        }.time.time.toDouble()/1000
        Assert.assertEquals(expected, actual, 1.0)
    }

    // RFC_3339_V1 type2 yyyy-MM-dd'T'HH:mm:ss'Z'
    @Test
    fun `test format RFC_3339_V1 type 2 to Date`() {
        val dateString = "2021-03-05T08:00:00Z"
        val actual = DateFormatter.parseISO8601(dateString)?.time.orZero().toDouble()
        val expected = Calendar.getInstance().apply {
            set(2021, 2, 5, 8, 0, 0)
        }.time.time.toDouble()
        Assert.assertEquals(expected, actual, 1000.0)
    }

    // RFC_3339_V1 type2 yyyy-MM-dd'T'H:mm:ss'Z'
    @Test
    fun `test format RFC_3339_V2 type 1 to Date`() {
        val dateString = "2021-03-05T8:00:00.123Z"
        val actual = DateFormatter.parseISO8601(dateString)?.time.orZero().toDouble()
        val expected = Calendar.getInstance().apply {
            set(2021, 2, 5, 8, 0, 0)
        }.time.time.toDouble()

        Assert.assertEquals(expected, actual, 1000.0)
    }

    // RFC_3339_V1 type2 yyyy-MM-dd'T'HH:mm:ss'Z'
    @Test
    fun `test format RFC_3339_V2 type 2 to Date`() {
        val dateString = "2021-03-05T8:00:00.123Z"
        val actual = DateFormatter.parseISO8601(dateString)?.time.orZero().toDouble()
        val expected = Calendar.getInstance().apply {
            set(2021, 2, 5, 8, 0, 0)
        }.time.time.toDouble()

        Assert.assertEquals(expected, actual, 1000.0)
    }
}
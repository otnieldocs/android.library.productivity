package com.otnieldocs.productivity.extensions

import org.junit.Assert
import org.junit.Test
import java.util.*

class TimeExtensionTest {
    @Test
    fun `Calculate remaining days from 2021-03-05 to 2021-03-09 in miles`() {
        val from = Calendar.getInstance().apply {
            set(2021,2,5)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 9)
        }.time

        val actual = to.remainingDays(from.time)
        val expected = 4
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `Calculate remaining days from 2021-03-05 to 2021-03-09 in date`() {
        val from = Calendar.getInstance().apply {
            set(2021,2,5)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 9)
        }.time

        val actual = to.remainingDays(from)
        val expected = 4
        Assert.assertEquals(expected, actual)
    }
}
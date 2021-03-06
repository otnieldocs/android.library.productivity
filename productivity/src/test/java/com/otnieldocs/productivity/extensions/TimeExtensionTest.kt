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

    @Test
    fun `Calculate remaining hours from 08_30_00 to 14_00_00 in millis`() {
        val from = Calendar.getInstance().apply {
            set(2021, 2, 3, 8, 30, 0)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 3, 14, 0, 0)
        }.time

        val actual = to.remainingHours(from.time)
        val expected = 5.5
        Assert.assertEquals(expected, actual, 0.05)
    }

    @Test
    fun `Calculate remaining hours from 08_30_00 to 14_00_00 in date`() {
        val from = Calendar.getInstance().apply {
            set(2021, 2, 3, 8, 30, 0)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 3, 14, 0, 0)
        }.time

        val actual = to.remainingHours(from)
        val expected = 5.5
        Assert.assertEquals(expected, actual, 0.05)
    }

    @Test
    fun `Calculate remaining minutes from 08_30_00 to 14_00_00 in millis`() {
        val from = Calendar.getInstance().apply {
            set(2021, 2, 3, 8, 30, 0)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 3, 9, 0, 0)
        }.time

        val actual = to.remainingMinutes(from.time)
        val expected = 30.0
        Assert.assertEquals(expected, actual, 0.05)
    }

    @Test
    fun `Calculate remaining minutes from 08_30_00 to 14_00_00 in date`() {
        val from = Calendar.getInstance().apply {
            set(2021, 2, 3, 8, 30, 0)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 3, 9, 0, 0)
        }.time

        val actual = to.remainingMinutes(from)
        val expected = 30.0
        Assert.assertEquals(expected, actual, 0.05)
    }

    @Test
    fun `Calculate remaining time from 08_30_00 to 14_00_00 in date`() {
        val from = Calendar.getInstance().apply {
            set(2021, 2, 3, 8, 30, 0)
        }.time

        val to = Calendar.getInstance().apply {
            set(2021, 2, 3, 9, 0, 0)
        }.time

        val actual = to.remaining(from.time)
        val expectedDiff = 30.0
        val expectedDiffType = DIFF_IN_MINUTE
        Assert.assertEquals(expectedDiff, actual.diff, 0.05)
        Assert.assertEquals(expectedDiffType, actual.type)
    }
}
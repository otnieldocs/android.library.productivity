package com.otnieldocs.productivity

import com.otnieldocs.productivity.common.biggerThan
import com.otnieldocs.productivity.common.lessThan
import com.otnieldocs.productivity.common.orZero
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CommonDataExtensionTest {
    @Before
    fun setUp() {}

    // int

    @Test
    fun `Set the Int value to null, return 0`() {
        val value: Int? = null
        val actual: Int = value.orZero()

        Assert.assertEquals(0, actual)
    }

    @Test
    fun `Set the Int value to null, check lessThan 0, throw NPE`() {
        val value: Int? = null

        try {
            value.lessThan(2)
            Assert.assertTrue(false)
        } catch (e: NullPointerException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    fun `Set the Int value to -1, check is lessThan 0, return true`() {
        val value: Int? = -1

        try {
            Assert.assertTrue(value.lessThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun `Set the Int value to 1, check is biggerThan 0, return true`() {
        val value: Int? = 1

        try {
            Assert.assertTrue(value.biggerThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    // long

    @Test
    fun `Set the Long value to null, return 0`() {
        val value: Long? = null
        val actual = value.orZero()

        Assert.assertEquals(0, actual)
    }

    @Test
    fun `Set the Long value to null, check lessThan 0, throw NPE`() {
        val value: Long? = null

        try {
            value.lessThan(2)
            Assert.assertTrue(false)
        } catch (e: NullPointerException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    fun `Set the Long value to -1, check is lessThan 0, return true`() {
        val value: Long? = -1

        try {
            Assert.assertTrue(value.lessThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun `Set the Long value to 1, check is biggerThan 0, return true`() {
        val value: Long? = 1

        try {
            Assert.assertTrue(value.biggerThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    // float

    @Test
    fun `Set the Float value to null, return 0`() {
        val value: Float? = null
        val actual = value.orZero()

        Assert.assertEquals(0F, actual)
    }

    @Test
    fun `Set the Float value to null, check lessThan 0, throw NPE`() {
        val value: Float? = null

        try {
            value.lessThan(2)
            Assert.assertTrue(false)
        } catch (e: NullPointerException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    fun `Set the Float value to -1, check is lessThan 0, return true`() {
        val value: Float? = -1F

        try {
            Assert.assertTrue(value.lessThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun `Set the Float value to 1, check is biggerThan 0, return true`() {
        val value: Float? = 1F

        try {
            Assert.assertTrue(value.biggerThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    // double

    @Test
    fun `Set the Double value to null, return 0`() {
        val value: Double? = null
        val actual = value.orZero()

        Assert.assertEquals(0.0, actual, 0.0)
    }

    @Test
    fun `Set the Double value to null, check lessThan 0, throw NPE`() {
        val value: Double? = null

        try {
            value.lessThan(2)
            Assert.assertTrue(false)
        } catch (e: NullPointerException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    fun `Set the Double value to -1, check is lessThan 0, return true`() {
        val value: Double? = -1.0

        try {
            Assert.assertTrue(value.lessThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun `Set the Double value to 1, check is biggerThan 0, return true`() {
        val value: Double? = 1.0

        try {
            Assert.assertTrue(value.biggerThan(0))
        } catch (e: NullPointerException) {
            Assert.assertTrue(false)
        }
    }
}
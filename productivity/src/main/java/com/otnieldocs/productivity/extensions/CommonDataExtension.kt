package com.otnieldocs.productivity.extensions

import java.lang.NullPointerException
import java.util.*

// Int extension
fun Int?.orZero(): Int = this ?: 0

@Throws(NullPointerException::class)
fun Int?.lessThan(value: Int): Boolean =
    if (this == null) throw NullPointerException() else this.orZero() < value

@Throws(NullPointerException::class)
fun Int?.biggerThan(value: Int): Boolean =
    if (this == null) throw NullPointerException() else this.orZero() > value

// Long extension
fun Long?.orZero(): Long = this ?: 0

@Throws(NullPointerException::class)
fun Long?.lessThan(value: Int): Boolean =
    if (this == null) throw NullPointerException() else this.orZero() < value

@Throws(NullPointerException::class)
fun Long?.biggerThan(value: Int): Boolean =
    if (this == null) throw NullPointerException() else this.orZero() > value

// Float extension
fun Float?.orZero(): Float = this ?: 0F

@Throws(NullPointerException::class)
fun Float?.lessThan(value: Int): Boolean =
    if (this == null) throw NullPointerException() else this.orZero() < value

@Throws(NullPointerException::class)
fun Float?.biggerThan(value: Int) =
    if (this == null) throw NullPointerException() else this.orZero() > value


// Double extension
fun Double?.orZero(): Double = this ?: 0.0

@Throws(NullPointerException::class)
fun Double?.lessThan(value: Int): Boolean =
    if (this == null) throw NullPointerException() else this.orZero() < value

@Throws(NullPointerException::class)
fun Double?.biggerThan(value: Int) =
    if (this == null) throw NullPointerException() else this.orZero() > value


// Boolean extension
fun Boolean?.orFalse() = this ?: false

// Date extension
fun Date?.orBeginning() = this ?: Date(0)


package com.afdhal_fa.unittestsample.calculator

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun givenTwoNumbers_whenSumInvoked_shouldReturnValidSumResult() {
        val expected = 4
        val actual = calculator.sum(2, 2)
        assertEquals(expected, actual)
    }
}
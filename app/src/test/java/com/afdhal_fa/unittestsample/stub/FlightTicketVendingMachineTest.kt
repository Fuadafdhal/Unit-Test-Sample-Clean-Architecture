package com.afdhal_fa.unittestsample.stub

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class FlightTicketVendingMachineTest {

    @Test
    fun givenListOfActiveFlights_whenFindActiveFlight_returnNumberOfActiveFlight() {
        //Given
        val database: FlightDatabase = mockk()
        val vendingMachine = FlightTicketVendingMachine(database)

        //Stub
        every { database.activeFlights() } returns listOf(Flight("Lombok", true), Flight("Bali", true))

        //When
        val actual = vendingMachine.findActiveFlightsCounts()

        //Then
        assertEquals(2, actual)
    }

    @Test
    fun givenListOfInactiveFlights_whenFindActiveFlight_returnNoActiveFlight() {
        //Given
        val database: FlightDatabase = mockk()
        val vendingMachine = FlightTicketVendingMachine(database)

        //Stub
        every { database.activeFlights() } returns listOf(Flight("Lombok", false), Flight("Bali", false))

        //When
        val actual = vendingMachine.findActiveFlightsCounts()

        assertEquals(0, actual)
    }

}
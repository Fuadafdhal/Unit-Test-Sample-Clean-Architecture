package com.afdhal_fa.unittestsample.stub

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class FlightTicketVendingMachine(private val database: FlightDatabase) {
    fun findActiveFlightsCounts(): Int {
        val flight = database.activeFlights()
        return flight.filter { it.isActive }.size
    }
}
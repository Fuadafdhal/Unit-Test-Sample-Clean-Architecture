package com.afdhal_fa.unittestsample.stub

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class FlightDatabase {
    /**
     * For demonstration purpose, we will provide the data by using dummy flight data.
     */
    fun activeFlights():List<Flight>{
        return listOf(
            Flight("Lombok", true),
            Flight("Bali", true),
            Flight("Papua", false)
        )
    }
}
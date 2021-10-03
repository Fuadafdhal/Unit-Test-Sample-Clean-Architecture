package com.afdhal_fa.unittestsample.mock

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class LaptopTest {

    @Test
    fun whenShuttingDownLaptop_shouldCloseSpotifyAndZoomApp() {
        //Given
        val spotify: Spotify = mockk()
        val zoom: Zoom = mockk()
        val laptop = Laptop(spotify, zoom)

        every { spotify.close() } returns Unit //Stubbing
        every { zoom.close() } returns Unit //Stubbing

        //When
        laptop.shutdown()

        //Then
        verify { zoom.close() } //Mocking
        verify { zoom.close() } //Mocking

    }
}
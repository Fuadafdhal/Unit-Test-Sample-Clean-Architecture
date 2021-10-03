package com.afdhal_fa.unittestsample.mock

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class Laptop(private val spotify: Spotify, private val zoom: Zoom) {
    fun shutdown() {
        spotify.close()
        zoom.close()
    }
}
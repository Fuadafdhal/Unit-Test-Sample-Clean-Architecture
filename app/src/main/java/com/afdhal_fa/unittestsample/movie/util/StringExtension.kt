package com.afdhal_fa.unittestsample.movie.util

import com.afdhal_fa.unittestsample.movie.util.MovieConstant.IMAGE_BASE_URL_POSTER

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

fun String.createImageUrl(): String {
    return IMAGE_BASE_URL_POSTER + this
}
package com.afdhal_fa.unittestsample.movie.abstraction

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

interface Mapper<in I, out O> {
    fun map(input: I): O
}
package com.afdhal_fa.unittestsample.movie.abstraction

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

interface UseCase<Params, out T> {
    suspend fun execute(params: Params): T

    object None
}
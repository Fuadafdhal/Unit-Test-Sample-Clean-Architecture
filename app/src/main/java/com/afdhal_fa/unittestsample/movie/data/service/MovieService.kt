package com.afdhal_fa.unittestsample.movie.data.service

import com.afdhal_fa.unittestsample.movie.data.response.GetPopularMoviesDto
import retrofit2.http.GET

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): GetPopularMoviesDto
}
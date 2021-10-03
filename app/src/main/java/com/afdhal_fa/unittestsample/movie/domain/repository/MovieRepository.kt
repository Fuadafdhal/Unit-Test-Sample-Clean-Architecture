package com.afdhal_fa.unittestsample.movie.domain.repository

import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

interface MovieRepository {
    suspend fun getPopularMovies(): Result<List<Movie>>
}
package com.afdhal_fa.unittestsample.movie.data.source

import com.afdhal_fa.unittestsample.movie.data.response.GetPopularMoviesDto
import com.afdhal_fa.unittestsample.movie.data.service.MovieService
import com.afdhal_fa.unittestsample.movie.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService
) : RemoteDataSource() {
    suspend fun getPopularMovies(dispatcher: CoroutineDispatcher): Result<GetPopularMoviesDto> {
        return safeApiCall(dispatcher) { movieService.getPopularMovies() }
    }
}
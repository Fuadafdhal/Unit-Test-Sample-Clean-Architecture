package com.afdhal_fa.unittestsample.movie.data.repository

import com.afdhal_fa.unittestsample.movie.data.dispatcher.DispatcherProvider
import com.afdhal_fa.unittestsample.movie.data.mapper.PopularMoviesEntityMapper
import com.afdhal_fa.unittestsample.movie.data.mapper.PopularMoviesMapper
import com.afdhal_fa.unittestsample.movie.data.source.MovieLocalDataSource
import com.afdhal_fa.unittestsample.movie.data.source.MovieRemoteDataSource
import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import com.afdhal_fa.unittestsample.movie.domain.repository.MovieRepository
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class MovieRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val mapper: PopularMoviesMapper,
    private val entityMapper: PopularMoviesEntityMapper,
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return when (val apiResult = remoteDataSource.getPopularMovies(dispatcher.io)) {
            is Result.Success -> {
                val movies = mapper.map(apiResult.data)
                localDataSource.insertAll(entityMapper.map(movies))
                Result.Success(movies)
            }

            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)

            else -> Result.Error()
        }
    }
}
package com.afdhal_fa.unittestsample.movie.data.source

import com.afdhal_fa.unittestsample.movie.data.db.MovieDatabase
import com.afdhal_fa.unittestsample.movie.data.db.MovieEntity
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class MovieLocalDataSource @Inject constructor(
    private val database: MovieDatabase
) {
    suspend fun insertAll(movies: List<MovieEntity>) {
        database.movieDao().insertAll(*movies.toTypedArray())
    }
}
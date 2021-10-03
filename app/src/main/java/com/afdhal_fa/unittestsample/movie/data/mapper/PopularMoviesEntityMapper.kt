package com.afdhal_fa.unittestsample.movie.data.mapper

import com.afdhal_fa.unittestsample.movie.abstraction.Mapper
import com.afdhal_fa.unittestsample.movie.data.db.MovieEntity
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class PopularMoviesEntityMapper @Inject constructor() : Mapper<List<Movie>, List<MovieEntity>> {
    override fun map(input: List<Movie>): List<MovieEntity> {
        return input.map { movie ->
            MovieEntity(movie.id, movie.title, movie.imageUrl)
        }
    }
}
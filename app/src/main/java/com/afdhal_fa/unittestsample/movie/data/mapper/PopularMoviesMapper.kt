package com.afdhal_fa.unittestsample.movie.data.mapper

import com.afdhal_fa.unittestsample.movie.abstraction.Mapper
import com.afdhal_fa.unittestsample.movie.data.response.GetPopularMoviesDto
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class PopularMoviesMapper @Inject constructor() : Mapper<GetPopularMoviesDto, List<Movie>> {
    override fun map(input: GetPopularMoviesDto): List<Movie> {
        val movies = mutableListOf<Movie>()
        for (movie in input.results.orEmpty()) {
            movies.add(
                Movie(
                    movie.id ?: 0,
                    movie.title.orEmpty(),
                    movie.posterPath.orEmpty()
                )
            )
        }
        return movies
    }
}
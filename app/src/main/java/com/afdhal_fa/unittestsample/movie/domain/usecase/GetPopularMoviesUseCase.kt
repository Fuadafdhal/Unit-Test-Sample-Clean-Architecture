package com.afdhal_fa.unittestsample.movie.domain.usecase

import com.afdhal_fa.unittestsample.movie.abstraction.UseCase
import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import com.afdhal_fa.unittestsample.movie.domain.repository.MovieRepository
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) : UseCase<UseCase.None, Result<List<Movie>>> {
    override suspend fun execute(params: UseCase.None): Result<List<Movie>> {
        return repository.getPopularMovies()
    }
}
package com.afdhal_fa.unittestsample.movie.domain.usecase

import com.afdhal_fa.unittestsample.helper.extension.runBlockingTest
import com.afdhal_fa.unittestsample.helper.rule.CoroutineTestRule
import com.afdhal_fa.unittestsample.movie.abstraction.UseCase
import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.domain.repository.MovieRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@ExperimentalCoroutinesApi
class GetPopularMoviesUseCaseTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private val repository: MovieRepository = mockk()
    private val useCase = GetPopularMoviesUseCase(repository)

    @Test
    fun whenGetPopularMoviesInvoked_shouldGetDataFromRepository() = coroutineTestRule.runBlockingTest {
        coEvery { repository.getPopularMovies() } returns Result.Success(emptyList())

        //When
        useCase.execute(UseCase.None)

        //Then
        coVerify { repository.getPopularMovies() }
    }
}
package com.afdhal_fa.unittestsample.movie.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.afdhal_fa.unittestsample.helper.rule.CoroutineTestRule
import com.afdhal_fa.unittestsample.movie.abstraction.UseCase
import com.afdhal_fa.unittestsample.movie.domain.HttpResult
import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import com.afdhal_fa.unittestsample.movie.domain.usecase.GetPopularMoviesUseCase
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@ExperimentalCoroutinesApi
class MovieListViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val useCase: GetPopularMoviesUseCase = mockk()
    private val observer: Observer<Result<List<Movie>>> = spyk()
    private val viewModel = MovieListViewModel(useCase)

    @Before
    fun setup() {
        viewModel.popularMovies.observeForever(observer)
    }

    @Test
    fun whenFetchPopularMovieSuccess_shouldEmitSuccessToObserver() {
        //Given
        val movies = populateDummyMovie()
        coEvery { useCase.execute(UseCase.None) } returns Result.Success(movies)

        //When
        viewModel.getPopularMovies()

        //Then
        verify {
            observer.onChanged(Result.Loading)
            observer.onChanged(Result.Success(movies))
        }
    }

    @Test
    fun whenFetchPopularMovieFailed_shouldEmitErrorToObserver() {
        //Given

        coEvery { useCase.execute(UseCase.None) } returns Result.Error(cause = HttpResult.TIMEOUT)

        //When
        viewModel.getPopularMovies()

        //Then
        verify {
            observer.onChanged(Result.Loading)
            observer.onChanged(Result.Error(cause = HttpResult.TIMEOUT))
        }
    }

    private fun populateDummyMovie(): List<Movie> {
        return listOf(
            Movie(1, "John Wick 3", "some-url"),
            Movie(2, "Money Heist", "some-url")
        )
    }

}
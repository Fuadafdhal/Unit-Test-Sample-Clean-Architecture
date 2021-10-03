package com.afdhal_fa.unittestsample.movie.data.repository

import com.afdhal_fa.unittestsample.helper.extension.runBlockingTest
import com.afdhal_fa.unittestsample.helper.rule.CoroutineTestRule
import com.afdhal_fa.unittestsample.movie.data.mapper.PopularMoviesEntityMapper
import com.afdhal_fa.unittestsample.movie.data.mapper.PopularMoviesMapper
import com.afdhal_fa.unittestsample.movie.data.response.GetPopularMoviesDto
import com.afdhal_fa.unittestsample.movie.data.source.MovieLocalDataSource
import com.afdhal_fa.unittestsample.movie.data.source.MovieRemoteDataSource
import com.afdhal_fa.unittestsample.movie.domain.Result
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
class MovieRepositoryImplTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private val mapper: PopularMoviesMapper = mockk(relaxed = true)
    private val entityMapper: PopularMoviesEntityMapper = mockk(relaxed = true)
    private val remoteDataSource: MovieRemoteDataSource = mockk()
    private val localDataSource: MovieLocalDataSource = mockk(relaxed = true)

    private val repository = MovieRepositoryImpl(
        coroutineTestRule.testDispatcherProvider,
        mapper,
        entityMapper,
        remoteDataSource,
        localDataSource
    )

    @Test
    fun whenGetPopularMovies_shouldGetPopularMoviesFromNetwork() =
        coroutineTestRule.runBlockingTest {
            //Given
            val dummyMovie = populateDummyPopularMoviesResponse()

            coEvery { remoteDataSource.getPopularMovies(coroutineTestRule.testDispatcher) } returns Result.Success(
                dummyMovie
            )

            //When
            repository.getPopularMovies()

            //Then
            coEvery { remoteDataSource.getPopularMovies(coroutineTestRule.testDispatcher) }
        }


    @Test
    fun whenGetPopularMoviesFromRemoteSuccess_shouldSaveDataToDatabase() =
        coroutineTestRule.runBlockingTest {
            //Given
            val dummyMovies = populateDummyPopularMoviesResponse()

            coEvery { remoteDataSource.getPopularMovies(coroutineTestRule.testDispatcher) } returns Result.Success(
                dummyMovies
            )

            //When
            repository.getPopularMovies()

            //Then
            coVerify { localDataSource.insertAll(any()) }
        }

    @Test
    fun whenGetPopularMoviesFromRemoteFailed_neverSaveDataToDatabase() =
        coroutineTestRule.runBlockingTest {
            //Given
            val dummyMovies = populateDummyPopularMoviesResponse()

            coEvery { remoteDataSource.getPopularMovies(coroutineTestRule.testDispatcher) } returns Result.Error()

            //When
            repository.getPopularMovies()

            //Then
            coVerify(exactly = 0) { localDataSource.insertAll(any()) }
        }

    private fun populateDummyPopularMoviesResponse(): GetPopularMoviesDto {
        return GetPopularMoviesDto()
    }

}
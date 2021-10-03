package com.afdhal_fa.unittestsample.movie.di.module

import com.afdhal_fa.unittestsample.movie.data.repository.MovieRepositoryImpl
import com.afdhal_fa.unittestsample.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: MovieRepositoryImpl): MovieRepository
}
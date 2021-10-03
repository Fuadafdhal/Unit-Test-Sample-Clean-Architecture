package com.afdhal_fa.unittestsample.movie.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afdhal_fa.unittestsample.movie.di.annotation.ViewModelKey
import com.afdhal_fa.unittestsample.movie.di.factory.ViewModelFactory
import com.afdhal_fa.unittestsample.movie.presentation.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    internal abstract fun provideMovieListViewModel(
        viewModel: MovieListViewModel
    ):ViewModel
}
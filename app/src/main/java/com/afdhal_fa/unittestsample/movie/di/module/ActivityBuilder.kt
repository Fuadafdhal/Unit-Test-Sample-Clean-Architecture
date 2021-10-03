package com.afdhal_fa.unittestsample.movie.di.module

import com.afdhal_fa.unittestsample.movie.presentation.MovieListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun contributesMovieListActivity():MovieListActivity
}
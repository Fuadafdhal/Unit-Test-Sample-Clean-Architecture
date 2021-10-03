package com.afdhal_fa.unittestsample.movie.di.module

import com.afdhal_fa.unittestsample.movie.data.dispatcher.CoroutineDispatcherProvider
import com.afdhal_fa.unittestsample.movie.data.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}
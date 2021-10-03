package com.afdhal_fa.unittestsample.movie.di.module

import android.app.Application
import android.content.Context
import com.afdhal_fa.unittestsample.movie.SampleApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: SampleApplication): Context = app

    @Provides
    @Singleton
    fun provideApplication(app: SampleApplication): Application = app
}
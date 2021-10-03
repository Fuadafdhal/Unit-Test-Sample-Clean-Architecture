package com.afdhal_fa.unittestsample.movie.di.module

import android.content.Context
import androidx.room.Room
import com.afdhal_fa.unittestsample.movie.data.db.MovieDao
import com.afdhal_fa.unittestsample.movie.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Module
class DatabaseModule {
    companion object {
        private const val DATABASE_NAME = "app_database"
    }

    @Provides
    @Singleton
    fun provideDataBase(context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao {
        return database.movieDao()
    }

}
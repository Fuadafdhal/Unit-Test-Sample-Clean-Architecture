package com.afdhal_fa.unittestsample.movie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Database(
    entities = [
        MovieEntity::class
    ],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
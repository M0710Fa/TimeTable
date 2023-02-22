package com.example.timetable.model.source

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TimeTableDatabaseModule {
    @Provides
    fun provideTimeTableDao(database: TimeTableDatabase): TimeTableDao{
        return database.timeTableDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TimeTableDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = TimeTableDatabase::class.java,
            name = "timetable_database"
        ).build()
    }
}

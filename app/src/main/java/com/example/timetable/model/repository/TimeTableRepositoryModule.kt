package com.example.timetable.model.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TimeTableRepositoryModule {
    @Provides
    fun provideTimeTableRepository(timeTableRepositoryImpl: TimeTableRepositoryImpl): TimeTableRepository {
        return timeTableRepositoryImpl
    }
}

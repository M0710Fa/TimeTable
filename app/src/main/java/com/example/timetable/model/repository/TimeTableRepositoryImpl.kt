package com.example.timetable.model.repository

import com.example.timetable.model.source.TimeTableDao
import javax.inject.Inject

class TimeTableRepositoryImpl @Inject constructor(
    private val timeTableDao: TimeTableDao,
): TimeTableRepository {

}
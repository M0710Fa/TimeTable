package com.example.timetable.model.repository

import com.example.timetable.model.source.Subject
import com.example.timetable.model.source.TimeTableDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TimeTableRepositoryImpl @Inject constructor(
    private val timeTableDao: TimeTableDao,
): TimeTableRepository {
    override suspend fun addSubject(subject: Subject) = timeTableDao.insertSubject(subject)

    override fun getSubjects(): Flow<List<Subject>> = timeTableDao.getAllSubjects()

}
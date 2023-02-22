package com.example.timetable.model.repository

import com.example.timetable.model.source.Subject
import kotlinx.coroutines.flow.Flow

interface TimeTableRepository {
    suspend fun addSubject(subject: Subject)
    fun getSubjects(): Flow<List<Subject>>
}

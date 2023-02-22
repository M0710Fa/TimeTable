package com.example.timetable.model.source

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TimeTableDao {
    @Insert
    suspend fun insertSubject(subject: Subject)

    @Update
    suspend fun updateSubject(subject: Subject)

    @Delete
    suspend fun deleteSubject(subject: Subject)

    @Query("SELECT * FROM subjects WHERE id = :id")
    suspend fun getSubject(id: Int):Subject

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): Flow<List<Subject>>

    @Query("DELETE FROM subjects")
    suspend fun deleteAllSubject()
}

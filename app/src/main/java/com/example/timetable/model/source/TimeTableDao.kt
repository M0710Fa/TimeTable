package com.example.timetable.model.source

import androidx.room.*

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
    suspend fun getAllSubjects(): List<Subject>

    @Query("DELETE FROM subjects")
    suspend fun deleteAllSubject()
}

package com.example.timetable.model.source

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TimeTableDao {
    /**
     *  add subject to subjects_table
     *  @param subject to be inserted
     * */
    @Insert
    suspend fun insertSubject(subject: Subject)

    /**
     *  update subject
     *  @param subject to be updated
     * */
    @Update
    suspend fun updateSubject(subject: Subject)

    /**
     *  delete subject from subjects_table
     *  @param subject to be deleted
     * */
    @Delete
    suspend fun deleteSubject(subject: Subject)

    /**
     *  select subject with id
     *  @param id is Subject id
     *  @return specified subject
     * */
    @Query("SELECT * FROM subjects WHERE id = :id")
    suspend fun getSubject(id: Int):Subject

    /**
     *  observe all subjects in subjects_table
     *  @return all subject
     * */
    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): Flow<List<Subject>>

    /**
     *  delete all subjects form subjects_table
     *
     * */
    @Deprecated("Use with Caution")
    @Query("DELETE FROM subjects")
    suspend fun deleteAllSubject()
}

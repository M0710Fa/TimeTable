package com.example.timetable.model.source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Subject::class], version = 1, exportSchema = false)
abstract class TimeTableDatabase : RoomDatabase() {
    abstract fun timeTableDao(): TimeTableDao
}

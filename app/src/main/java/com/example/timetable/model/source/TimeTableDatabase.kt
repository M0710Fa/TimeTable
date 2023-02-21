package com.example.timetable.model.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subject::class], version = 1)
abstract class TimeTableDatabase: RoomDatabase() {
    abstract fun timeTableDao() : TimeTableDao

    companion object {
        @Volatile
        private var INSTANCE: TimeTableDatabase? = null

        fun getDatabase(context: Context): TimeTableDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TimeTableDatabase::class.java,
                    "timetable_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
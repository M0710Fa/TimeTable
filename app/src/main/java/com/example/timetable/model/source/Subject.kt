package com.example.timetable.model.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo("subject_name")
    val subjectName: String = "no_name",

    @ColumnInfo("class_room")
    val classRoom: String? = null,

    @ColumnInfo("teacher")
    val teacher: String? = null,

    @ColumnInfo("subject_color")
    val subjectColor: String,
)

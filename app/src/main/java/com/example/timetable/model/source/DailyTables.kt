package com.example.timetable.model.source

data class DailyTables(
    val week: String,
    val subjects: Map<Int, Subject?>,
)

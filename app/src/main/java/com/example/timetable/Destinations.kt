package com.example.timetable

sealed class Destinations(
    val route: String,
    val title: String,
) {

    object TimeTableScreen: Destinations(
        route = "timetable_screen",
        title = "時間割り",
    )

    object SubjectsScreen: Destinations(
        route = "subjects_screen",
        title = "科目管理",
    )

}
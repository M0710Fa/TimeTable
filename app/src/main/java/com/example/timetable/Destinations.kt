package com.example.timetable

sealed class Destinations(
    val route: String,
    val title: String,
) {

    object TableScreen : Destinations(
        route = "table_screen",
        title = "時間割り",
    )

    object SubjectsScreen : Destinations(
        route = "subjects_screen",
        title = "科目管理",
    )
}

enum class TopLevelDestinations(
    val destinations: Destinations
){
    TABLE(Destinations.TableScreen),
    SUBJECT(Destinations.SubjectsScreen),
}

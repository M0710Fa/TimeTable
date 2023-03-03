package com.example.timetable

import androidx.annotation.StringRes

sealed class Destinations(
    @StringRes val title: Int,
    val route: String,
) {

    object TableScreen : Destinations(
        title = R.string.timetable_title,
        route = "table_screen",
    )

    object SubjectsScreen : Destinations(
        title = R.string.subjects_title,
        route = "subjects_screen",
    )
}

enum class TopLevelDestinations(
    val destinations: Destinations
){
    TABLE(Destinations.TableScreen),
    SUBJECT(Destinations.SubjectsScreen),
}

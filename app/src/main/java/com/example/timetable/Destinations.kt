package com.example.timetable

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.TableView
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String,
) {

    object TableScreen : Destinations(
        title = R.string.timetable_title,
        icon = Icons.Outlined.TableView,
        route = "table_screen",
    )

    object ManageSubjectsScreen : Destinations(
        title = R.string.subjects_title,
        icon = Icons.Outlined.List,
        route = "manage_subjects_screen",
    )

    object AddSubjectScreen : Destinations(
        title = R.string.add_subjects_title,
        icon = Icons.Default.Add,
        route = "add_subject_screen",
    )

    object SelectSubjectScreen : Destinations(
        title = R.string.select_subject_title,
        icon = Icons.Default.Task,
        route = "select_subject_screen/{week}/{time}",
    )
}

enum class TopLevelDestinations(
    val destinations: Destinations,
) {
    TABLE(Destinations.TableScreen),
    SUBJECT(Destinations.ManageSubjectsScreen),
}

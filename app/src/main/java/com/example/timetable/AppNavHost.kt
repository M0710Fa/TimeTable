package com.example.timetable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetable.ui.addSubject.AddSubjectScreen
import com.example.timetable.ui.main.MainScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = Destinations.TimeTableScreen.route) {
            MainScreen()
        }
        composable(route = Destinations.SubjectsScreen.route) {
            AddSubjectScreen()
        }
    }
}

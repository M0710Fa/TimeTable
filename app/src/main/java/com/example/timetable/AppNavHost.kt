package com.example.timetable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetable.ui.addSubject.AddSubjectScreen
import com.example.timetable.ui.table.TableScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    val navController = rememberNavController()
    Column() {
        NavHost(
            navController = navController,
            startDestination = startDestination,
        ) {
            composable(route = Destinations.TableScreen.route) {
                TableScreen()
            }
            composable(route = Destinations.SubjectsScreen.route) {
                AddSubjectScreen()
            }
        }


    }
}

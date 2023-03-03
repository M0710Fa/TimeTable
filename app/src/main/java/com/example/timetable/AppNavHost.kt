package com.example.timetable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.timetable.ui.addSubject.AddSubjectScreen
import com.example.timetable.ui.table.TableScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                TopLevelDestinations.values().forEach { item ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.destinations.route } == true,
                        icon = { Icon(item.destinations.icon, null) },
                        label = {
                            Text(
                                text = stringResource(id = item.destinations.title),
                                maxLines = 1,
                            )
                        },
                        onClick = {
                            navController.navigate(item.destinations.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
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

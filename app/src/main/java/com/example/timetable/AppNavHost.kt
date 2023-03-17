package com.example.timetable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.timetable.ui.addSubject.AddSubjectScreen
import com.example.timetable.ui.manageSubjects.ManageSubjectsScreen
import com.example.timetable.ui.table.SelectSubjectScreen
import com.example.timetable.ui.table.TableScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    val navController = rememberAnimatedNavController()

    val showedScreen = navController.currentBackStackEntryAsState().value?.destination?.route
    val bottomBarState = when (showedScreen) {
        Destinations.AddSubjectScreen.route -> false
        Destinations.SelectSubjectScreen.route -> false
        else -> true
    }

    Scaffold(
        bottomBar = {
            if (bottomBarState) {
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
            }
        },
    ) { innerPadding ->
        AnimatedNavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = startDestination,
        ) {
            composable(route = Destinations.TableScreen.route) {
                TableScreen(navController = navController)
            }

            composable(route = Destinations.ManageSubjectsScreen.route) {
                ManageSubjectsScreen(
                    transitionToAddSubject = { navController.navigate(Destinations.AddSubjectScreen.route) },
                )
            }

            composable(
                route = Destinations.AddSubjectScreen.route,
                enterTransition = {
                    slideInVertically(initialOffsetY = { fullHeight -> fullHeight - 100 })
                },
                exitTransition = {
                    slideOutVertically(targetOffsetY = { fullHeight -> fullHeight - 100 })
                },
            ) {
                AddSubjectScreen(
                    transitionToBackStack = { navController.popBackStack() },
                )
            }

            composable(
                route = Destinations.SelectSubjectScreen.route,
                arguments = listOf(
                    navArgument("selected") { type = NavType.StringType },
                ),
            ) { backStackEntry ->
                SelectSubjectScreen(selected = backStackEntry?.arguments?.getString("selected") ?: "999")
            }
        }
    }
}

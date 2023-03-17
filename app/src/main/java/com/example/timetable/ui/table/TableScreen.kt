package com.example.timetable.ui.table

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.timetable.ui.table.timeTable.BlankTable
import com.example.timetable.ui.table.timeTable.TimeTable

@Composable
fun TableScreen(
    modifier: Modifier = Modifier,
    viewModel: TableViewModel = hiltViewModel(),
    navController: NavController,
) {
    val weeksHeight = 32.dp
    val timesWidth = 24.dp

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box() {
        BlankTable(
            timeTable = MockTimeTable.timetable,
            weeksHeight = weeksHeight,
            timesWidth = timesWidth,
            weeks = uiState.weeks,
            times = uiState.times,
        )
        TimeTable(
            timeTable = MockTimeTable.timetable,
            weeksHeight = weeksHeight,
            timesWidth = timesWidth,
            weeks = uiState.weeks,
            times = uiState.times,
            navController = navController,
        )
    }
}

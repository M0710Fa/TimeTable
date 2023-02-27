package com.example.timetable.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetable.ui.main.timeTable.BlankTable
import com.example.timetable.ui.main.timeTable.TimeTable

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val weeksHeight = 32.dp
    val timesWidth = 24.dp

    Box() {
        BlankTable(timeTable = MockTimeTable.timetable, weeksHeight = weeksHeight, timesWidth = timesWidth)
        TimeTable(timeTable = MockTimeTable.timetable, weeksHeight = weeksHeight, timesWidth = timesWidth)
    }
}

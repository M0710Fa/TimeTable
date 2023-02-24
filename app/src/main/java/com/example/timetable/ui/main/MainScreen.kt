package com.example.timetable.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.timetable.ui.main.timeTable.BlankTable
import com.example.timetable.ui.main.timeTable.TimeTable

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    Box(){
        BlankTable(timeTable = MockTimeTable.timetable)
        TimeTable(timeTable = MockTimeTable.timetable)
    }
}



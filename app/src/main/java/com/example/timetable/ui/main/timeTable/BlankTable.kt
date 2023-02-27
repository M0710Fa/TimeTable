package com.example.timetable.ui.main.timeTable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.timetable.model.source.DailyTables

@Composable
fun BlankTable(
    modifier: Modifier = Modifier,
    timeTable: List<DailyTables>,
    weeksHeight: Dp,
    timesWidth: Dp,
) {
    Column(
        modifier = modifier
            .background(
                color = Color.LightGray,
            )
            .padding(4.dp),
    ) {
        // Top Row Display Weeks
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            val tableWeight = 1f
            Spacer(modifier = modifier.width(timesWidth))
            timeTable.forEach { daily ->
                Box(
                    modifier = modifier
                        .weight(tableWeight)
                        .height(weeksHeight),
                ) {
                    Text(
                        text = daily.week,
                        modifier = modifier.align(Alignment.Center),
                    )
                }
            }
        }

        // Display TimeTable
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = modifier.width(timesWidth),
            ) {
                for (i in 1..timeTable[0].subjects.size) {
                    Text(
                        text = i.toString(),
                        modifier = modifier
                            .fillMaxSize()
                            .wrapContentHeight()
                            .weight(.1f),
                    )
                }
            }
            Row() {
                timeTable.forEach { daily ->
                    Box(modifier = modifier.weight(.1f)) {
                        BlankColumn()
                    }
                }
            }
        }
    }
}

@Composable
fun BlankColumn(
    modifier: Modifier = Modifier,
) {
    Column() {
        for (i in 1..5) {
            BlackSubject(modifier = modifier.weight(.1f))
        }
    }
}

@Composable
fun BlackSubject(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(2.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(4.dp),
            ),
    )
}

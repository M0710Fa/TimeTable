package com.example.timetable.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.timetable.model.source.DailyTables
import com.example.timetable.model.source.Subject

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    TimeTable(timeTable = MockTimeTable.timetable)
}

@Composable
fun TimeTable(
    modifier: Modifier = Modifier,
    timeTable: List<DailyTables>,
) {
    val timesWidth = 20.dp
    Column() {
        // Top Row Display Weeks
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            val tableWeight = 1f
            Spacer(modifier = modifier.width(timesWidth))
            timeTable.forEach { daily ->
                Text(
                    text = daily.week,
                    modifier = modifier
                        .weight(tableWeight)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                        ),
                    textAlign = TextAlign.Center
                    ,
                )
            }
        }

        // Display TimeTable
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = modifier.width(timesWidth)
                ,
            ) {
                for (i in 1..timeTable[0].subjects.size) {
                    Text(
                        text = i.toString(),
                        modifier = modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                            )
                            .wrapContentHeight()
                            .weight(.1f),
                    )
                }
            }
            Row(
                modifier = modifier.background(
                    shape = RoundedCornerShape(4.dp),
                    color = MaterialTheme.colorScheme.background
                )
            ) {
                timeTable.forEach { daily ->
                    Box(modifier = modifier.weight(.1f)){
                        BlankColumn()
                        DailyColumn(dailySubject = daily.subjects)
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
    Column(
        modifier = modifier,
    ) {
        for(i in 1..5) {
            BlackSubject(modifier = modifier.weight(.1f))
        }
    }
}

@Composable
fun DailyColumn(
    modifier: Modifier = Modifier,
    dailySubject: Map<Int, Subject?>,
) {
    Column(
        modifier = modifier,
    ) {
        dailySubject.forEach {
            it.value.let {subject -> 
                if (subject != null)SubjectCard(subject = subject, modifier = modifier.weight(.1f))
                else Spacer(modifier = modifier.weight(.1f))
            }
        }
    }
}

@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    subject: Subject,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
    ) {
        Column(
            modifier = modifier
                .padding(4.dp),
        ) {
            Text(text = subject.subjectName)
            Text(text = subject.classRoom ?: "")
            Text(text = subject.teacher ?: "")
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
            .border(
                width = 1.dp,
                color = Color.LightGray,
            )
    )
}

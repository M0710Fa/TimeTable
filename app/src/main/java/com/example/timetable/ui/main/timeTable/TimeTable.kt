package com.example.timetable.ui.main.timeTable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.timetable.model.source.DailyTables
import com.example.timetable.model.source.Subject

@Composable
fun TimeTable(
    modifier: Modifier = Modifier,
    timeTable: List<DailyTables>,
) {
    val timesWidth = 20.dp
    Column() {
        Spacer(
            modifier = modifier
                .fillMaxWidth().height(24.dp)
        )

        // Display TimeTable
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = modifier.width(timesWidth))
            Row(
                modifier = modifier.background(
                    color = Color.Transparent,
                )
            ) {
                timeTable.forEach { daily ->
                    Box(modifier = modifier.weight(.1f)){
                        DailyColumn(dailySubject = daily.subjects)
                    }
                }
            }
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

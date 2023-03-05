package com.example.timetable.ui.table.timeTable

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.timetable.model.source.DailyTables
import com.example.timetable.model.source.Subject

@Composable
fun TimeTable(
    modifier: Modifier = Modifier,
    timeTable: List<DailyTables>,
    weeksHeight: Dp,
    timesWidth: Dp,
) {
    Column(
        modifier = modifier.padding(4.dp),
    ) {
        Spacer(
            modifier = modifier
                .fillMaxWidth().height(weeksHeight),
        )

        // Display TimeTable
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            Spacer(modifier = modifier.width(timesWidth))
            Row(
                modifier = modifier.background(
                    color = Color.Transparent,
                ),
            ) {
                timeTable.forEach { daily ->
                    Box(modifier = modifier.weight(.1f)) {
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
            it.value.let { subject ->
                if (subject != null) {
                    SubjectCard(subject = subject, modifier = modifier.weight(.1f))
                } else {
                    Spacer(modifier = modifier.weight(.1f))
                }
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
            .padding(2.dp),
        shape = RoundedCornerShape(4.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = subject.subjectName,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
            )
            Text(
                text = subject.classRoom ?: "",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
            )
            Text(
                text = subject.teacher ?: "",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
            )
        }
    }
}

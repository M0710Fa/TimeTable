package com.example.timetable.ui.table.timeTable

import android.util.Log
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.timetable.Destinations
import com.example.timetable.model.source.DailyTables
import com.example.timetable.model.source.Subject

@Composable
fun TimeTable(
    modifier: Modifier = Modifier,
    timeTable: List<DailyTables>,
    weeksHeight: Dp,
    timesWidth: Dp,
    weeks: Int,
    times: Int,
    navController: NavController,
) {
    val cardId = weeks * times
    Column(
        modifier = modifier.padding(4.dp),
    ) {
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(weeksHeight),
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
                timeTable.forEachIndexed() { index, daily ->
                    Box(modifier = modifier.weight(.1f)) {
                        DailyColumn(
                            dailySubject = daily.subjects,
                            cardId = index*times,
                            navController = navController
                        )
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
    cardId: Int,
    navController: NavController,
) {
    var i = 0
    Column(
        modifier = modifier,
    ) {
        dailySubject.forEach() { subject ->
            SubjectCard(
                subject = subject.value,
                modifier = modifier.weight(.1f),
                cardId = cardId + i,
                navController = navController)
            i ++
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    subject: Subject?,
    cardId: Int,
    navController: NavController,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp),
        shape = RoundedCornerShape(4.dp),
        onClick = {
            Log.d("aaaaaa", "clicked $cardId")
            navController.navigate(Destinations.SelectSubjectScreen.route.replace(oldValue = "selected", newValue = "$cardId"))
        }
    ) {
        if (subject != null) {
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
        } else{
            Spacer(modifier = modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background))
        }
    }
}

@Preview
@Composable
fun PreviewSubjectCard() {
    val subject = Subject(
        id = 0,
        subjectName = "科目名",
        classRoom = null,
        teacher = null,
        subjectColor = ""
    )
}

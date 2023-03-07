package com.example.timetable.ui.manageSubjects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.timetable.model.source.Subject

@Composable
fun ManageSubjectsScreen(
    modifier: Modifier = Modifier,
    viewModel: ManageSubjectsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    DisplaySubjects(subjects = uiState.subjects)
}

@Composable
fun DisplaySubjects(
    modifier: Modifier = Modifier,
    subjects: List<Subject>,
) {
    Column(
        modifier = modifier.padding(8.dp),
    ) {
        Text(
            text = "登録された科目一覧",
            style = MaterialTheme.typography.titleLarge,
        )
        LazyColumn(
            modifier = modifier.padding(8.dp),
        ) {
            items(subjects) {
                SubjectContent(subject = it)
            }
        }
    }
}

@Composable
fun SubjectContent(
    modifier: Modifier = Modifier,
    subject: Subject,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        content = {
            Box(modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
                Column() {
                    Text(
                        text = subject.subjectName,
                        modifier = modifier.padding(8.dp),
                    )
                    Row() {
                        Text(text = subject.classRoom ?: "")
                        Spacer(modifier = modifier.width(16.dp))
                        Text(text = subject.teacher ?: "")
                    }
                }
            }
        },
    )
}

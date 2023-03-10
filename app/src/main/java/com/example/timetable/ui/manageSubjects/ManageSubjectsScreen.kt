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
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.timetable.model.source.Subject

@Composable
fun ManageSubjectsScreen(
    modifier: Modifier = Modifier,
    viewModel: ManageSubjectsViewModel = hiltViewModel(),
    transitionToAddSubject: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { transitionToAddSubject() },
            ) {
                Icon(Icons.Default.Add, null)
            }
        },
    ) {
        DisplaySubjects(
            subjects = uiState.subjects,
            modifier = modifier.padding(it),
        )
    }
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
            style = MaterialTheme.typography.headlineSmall,
            modifier = modifier.padding(4.dp),
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
                Column(
                    modifier = modifier.padding(4.dp),
                ) {
                    Text(
                        text = subject.subjectName,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Row() {
                        val style = MaterialTheme.typography.bodyMedium
                        Text(
                            text = subject.classRoom ?: "",
                            style = style,
                        )
                        Spacer(modifier = modifier.width(16.dp))
                        Text(
                            text = subject.teacher ?: "",
                            style = style,
                        )
                    }
                }
            }
        },
    )
}

@Preview
@Composable
fun PreviewDisplaySubject() {
    val subjects = mutableListOf<Subject>()

    for (i in 0..10) {
        val subject = Subject(
            id = i,
            subjectName = "科目：$i",
            classRoom = null,
            teacher = null,
            subjectColor = "",
        )
        subjects.add(subject)
    }
    Surface() {
        DisplaySubjects(subjects = subjects)
    }
}

@Preview
@Composable
fun PreviewSubjectContentWhenOnlyName() {
    val subject = Subject(
        id = 0,
        subjectName = "科目名",
        classRoom = null,
        teacher = null,
        subjectColor = "",
    )
    SubjectContent(subject = subject)
}

@Preview
@Composable
fun PreviewSubjectContentWhenAllInfo() {
    val subject = Subject(
        id = 0,
        subjectName = "科目名",
        classRoom = "教室名",
        teacher = "担当教員",
        subjectColor = "",
    )
    SubjectContent(subject = subject)
}

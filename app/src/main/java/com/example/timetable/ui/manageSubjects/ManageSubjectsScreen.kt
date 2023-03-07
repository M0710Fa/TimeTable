package com.example.timetable.ui.manageSubjects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.timetable.model.source.Subject
import com.example.timetable.ui.addSubject.SubjectContent

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
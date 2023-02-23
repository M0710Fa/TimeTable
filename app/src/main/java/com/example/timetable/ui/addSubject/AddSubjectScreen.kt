package com.example.timetable.ui.addSubject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.timetable.R
import com.example.timetable.model.source.Subject

@Composable
fun AddSubjectScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column() {
        AddSubjectContent(
            subjectName = uiState.subjectName,
            classRoom = uiState.classRoom,
            teacher = uiState.teacher,
            updateSubjectName = viewModel::updateSubjectName,
            updateClassRoom = viewModel::updateClassRoom,
            updateTeacher = viewModel::updateTeacher,
            registerSubject = viewModel::addSubject,
        )

        DisplaySubjects(
            subjects = uiState.subjects,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSubjectContent(
    modifier: Modifier = Modifier,
    subjectName: String,
    classRoom: String,
    teacher: String,
    updateSubjectName: (String) -> Unit,
    updateClassRoom: (String) -> Unit,
    updateTeacher: (String) -> Unit,
    registerSubject: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        val textFieldModifier = modifier
            .align(Alignment.CenterHorizontally)

        Text(
            text = "科目の登録",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(8.dp),
        )
        OutlinedTextField(
            value = subjectName,
            onValueChange = { updateSubjectName(it) },
            label = {
                Text(text = stringResource(id = R.string.subject_name))
            },
            modifier = textFieldModifier,
        )
        OutlinedTextField(
            value = classRoom,
            onValueChange = { updateClassRoom(it) },
            label = {
                Text(text = stringResource(id = R.string.class_room))
            },
            modifier = textFieldModifier,
        )
        OutlinedTextField(
            value = teacher,
            onValueChange = { updateTeacher(it) },
            label = {
                Text(text = stringResource(id = R.string.teacher))
            },
            modifier = textFieldModifier,
        )

        Button(
            onClick = {
                registerSubject()
            },
            modifier = modifier
                .align(Alignment.End)
                .padding(8.dp),
        ) {
            Text(text = "科目登録")
        }
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
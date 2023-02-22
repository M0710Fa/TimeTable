package com.example.timetable.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AddSubjectScreen(
        subjectName = uiState.subjectName,
        classRoom = uiState.classRoom,
        teacher = uiState.teacher,
        updateSubjectName = viewModel::updateSubjectName,
        updateClassRoom = viewModel::updateClassRoom,
        updateTeacher = viewModel::updateTeacher,
        registerSubject = viewModel::addSubject
    )
}

@Composable
fun AddSubjectScreen(
    modifier: Modifier = Modifier,
    subjectName: String,
    classRoom: String,
    teacher: String,
    updateSubjectName:(String) -> Unit,
    updateClassRoom:(String) -> Unit,
    updateTeacher:(String) -> Unit,
    registerSubject:() -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        val textFieldModifier = modifier
            .align(Alignment.CenterHorizontally).padding(8.dp)

        Text(text = "科目登録")
        OutlinedTextField(
            value = subjectName,
            onValueChange = { updateSubjectName(it) },
            label = {
                Text(text = stringResource(id = R.string.subject_name))
            },
            modifier = textFieldModifier
        )
        OutlinedTextField(
            value = classRoom,
            onValueChange = { updateClassRoom(it) },
            label = {
                Text(text = stringResource(id = R.string.class_room))
            },
            modifier = textFieldModifier
        )
        OutlinedTextField(
            value = teacher,
            onValueChange = { updateTeacher(it) },
            label = {
                Text(text = stringResource(id = R.string.teacher))
            },
            modifier = textFieldModifier
        )

        Button(
            onClick = {
                registerSubject()
            },
            modifier = modifier.align(Alignment.End).padding(8.dp)
        ) {
            Text(text = "科目登録")
        }


    }
}
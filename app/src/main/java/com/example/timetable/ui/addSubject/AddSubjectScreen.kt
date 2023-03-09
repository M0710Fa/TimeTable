package com.example.timetable.ui.addSubject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.timetable.R

@Composable
fun AddSubjectScreen(
    modifier: Modifier = Modifier,
    viewModel: AddSubjectViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
    ) {
        Row(
            modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Default.Close,
                    null,
                    modifier = modifier.weight(.1f)
                )
            }
            Spacer(modifier = modifier.weight(.3f))

            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(
                    text = "科目登録",
                )
            }
        }
        AddSubjectContent(
            subjectName = uiState.subjectName,
            classRoom = uiState.classRoom,
            teacher = uiState.teacher,
            updateSubjectName = viewModel::updateSubjectName,
            updateClassRoom = viewModel::updateClassRoom,
            updateTeacher = viewModel::updateTeacher,
            registerSubject = viewModel::addSubject,
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
    }
}

@Preview
@Composable
fun PreviewAddSubject() {
    Surface() {
        AddSubjectContent(
            subjectName = "",
            classRoom = "",
            teacher = "",
            updateSubjectName = {},
            updateClassRoom = {},
            updateTeacher = {},
            registerSubject = {},
        )
    }
}
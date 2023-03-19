package com.example.timetable.ui.table

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.timetable.Destinations
import com.example.timetable.model.source.Subject
import com.example.timetable.ui.selectSubject.SelectSubjectViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectSubjectScreen(
    modifier: Modifier = Modifier,
    selected: String,
    viewModel: SelectSubjectViewModel = hiltViewModel(),
) {
    val selected = selected.replace("[{|}]".toRegex(), "")
    val selectedId = selected.toInt()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.padding(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = modifier.padding(end = 16.dp),
            ) {
                Icon(Icons.Default.ArrowBack, null)
            }
            Text(
                text = "${selected}の科目を選択してください",
                style = MaterialTheme.typography.titleLarge,
            )
        }
        Text(
            text = stringResource(id = Destinations.SelectSubjectScreen.title),
            style = MaterialTheme.typography.titleLarge,
        )
        Text("Selected Card $selected")
        SelectSubjectList(subjects = uiState.subjects)
    }
}

@Composable
fun SelectSubjectList(
    modifier: Modifier = Modifier,
    subjects: List<Subject>,
) {
    LazyColumn {
        items(subjects) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp),
            ) {
                Text(
                    text = it.subjectName,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(16.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSelectedSubject() {
    Surface() {
        SelectSubjectScreen(selected = "999")
    }
}

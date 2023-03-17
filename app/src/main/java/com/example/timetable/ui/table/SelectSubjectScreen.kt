package com.example.timetable.ui.table

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timetable.Destinations

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectSubjectScreen(
    modifier: Modifier = Modifier,
    selected: String,
) {
    val selectedId = selected.toInt()

    Column(
        modifier = modifier.padding(8.dp),
    ) {
        Text(
            text = stringResource(id = Destinations.SelectSubjectScreen.title),
            style = MaterialTheme.typography.titleLarge,
        )
        Text("Selected Card $selected")
    }
}

@Preview
@Composable
fun PreviewSelectedSubject() {
    Surface() {
        SelectSubjectScreen(selected = "999")
    }
}

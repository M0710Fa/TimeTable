package com.example.timetable.ui.manageSubjects

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.timetable.model.repository.TimeTableRepository
import com.example.timetable.model.source.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

data class ManageSubjectUiState(
    val subjects: List<Subject> = emptyList(),
    )

@HiltViewModel
class ManageSubjectsViewModel @Inject constructor(
    private val timeTableRepository: TimeTableRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ManageSubjectUiState())
    val uiState = _uiState
}
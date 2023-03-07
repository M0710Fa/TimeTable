package com.example.timetable.ui.manageSubjects

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetable.model.repository.TimeTableRepository
import com.example.timetable.model.source.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ManageSubjectUiState(
    val subjects: List<Subject> = emptyList(),
)

@HiltViewModel
class ManageSubjectsViewModel @Inject constructor(
    private val timeTableRepository: TimeTableRepository,
) : ViewModel() {
    private val TAG = "ManageSubjectsViewModel"

    private val _uiState = MutableStateFlow(ManageSubjectUiState())
    val uiState = _uiState

    init {
        getAllSubject()
    }

    private fun getAllSubject() = viewModelScope.launch {
        try {
            timeTableRepository.getSubjects().collect { subjects ->
                _uiState.update {
                    it.copy(subjects = subjects)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failure Get Subject with $e")
        }
    }
}

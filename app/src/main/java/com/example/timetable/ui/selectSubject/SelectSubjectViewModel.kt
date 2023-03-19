package com.example.timetable.ui.selectSubject

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetable.model.repository.TimeTableRepository
import com.example.timetable.model.source.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SelectSubjectUiState(
    val subjects: List<Subject> = emptyList()
)

@HiltViewModel
class SelectSubjectViewModel @Inject constructor(
    private val timeTableRepository: TimeTableRepository
): ViewModel() {

    val TAG = "SelectSubjectViewModel"

    private val _uiState = MutableStateFlow(SelectSubjectUiState())
    val uiState: StateFlow<SelectSubjectUiState> = _uiState

    init{
        fetchSubjects()
    }

    fun fetchSubjects() = viewModelScope.launch{
        try {
            timeTableRepository.getSubjects().collect{ subjects ->
                _uiState.update {
                    it.copy(subjects = subjects)
                }
            }
        }catch (e: Exception){
            Log.d(TAG, "Error with $e")
        }
    }
}
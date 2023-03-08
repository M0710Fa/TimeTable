package com.example.timetable.ui.addSubject

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

data class AddSubjectUiState(
    val subjectName: String = "",
    val classRoom: String = "",
    val teacher: String = "",
)

@HiltViewModel
class AddSubjectViewModel @Inject constructor(
    private val timeTableRepository: TimeTableRepository,
) : ViewModel() {
    private val TAG = "AddSubjectViewModel"

    private val _uiState = MutableStateFlow(AddSubjectUiState())
    val uiState: StateFlow<AddSubjectUiState> = _uiState

    fun updateSubjectName(newSubjectName: String) {
        _uiState.update {
            it.copy(subjectName = newSubjectName)
        }
    }

    fun updateClassRoom(newClassRoom: String) {
        _uiState.update {
            it.copy(classRoom = newClassRoom)
        }
    }

    fun updateTeacher(newTeacher: String) {
        _uiState.update {
            it.copy(teacher = newTeacher)
        }
    }

    fun addSubject() = viewModelScope.launch {
        try {
            val newSubject = Subject(
                subjectName = _uiState.value.subjectName.let {
                    if (it.isEmpty()) {
                        throw CollectSubjectError()
                    } else {
                        _uiState.value.subjectName
                    }
                },
                classRoom = _uiState.value.classRoom,
                teacher = _uiState.value.teacher,
                subjectColor = "",
            )
            Log.d(TAG, "Success Insert Subject")
            timeTableRepository.addSubject(newSubject)
        } catch (e: CollectSubjectError) {
            Log.e(TAG, "Failure Insert Subject with $e")
        } catch (e: Exception) {
            Log.e(TAG, "Failure Insert Subject with $e")
        }
    }
}

class CollectSubjectError : Exception("No Subject Name")

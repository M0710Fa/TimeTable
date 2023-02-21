package com.example.timetable.ui.main

import androidx.lifecycle.ViewModel
import com.example.timetable.model.source.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class MainUiState(
    val subjectName: String = "",
    val classRoom: String = "",
    val teacher:String = ""
)

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    fun updateSubjectName(newSubjectName: String){
        _uiState.update {
            it.copy(subjectName = newSubjectName)
        }
    }

    fun updateClassRoom(newClassRoom: String){
        _uiState.update {
            it.copy(classRoom = newClassRoom)
        }
    }

    fun updateTeacher(newTeacher: String){
        _uiState.update {
            it.copy(teacher = newTeacher)
        }
    }

    fun addSubject(subject: Subject){

    }
}
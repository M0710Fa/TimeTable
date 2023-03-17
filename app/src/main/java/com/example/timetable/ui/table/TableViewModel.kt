package com.example.timetable.ui.table

import androidx.lifecycle.ViewModel
import com.example.timetable.model.repository.TimeTableRepository
import com.example.timetable.model.source.DailyTables
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class TableUiState(
    val subjectsTable: List<DailyTables> = emptyList(),
    val weeks: Int = 0,
    val times: Int = 0,
)

@HiltViewModel
class TableViewModel @Inject constructor(
    private val timeTableRepository: TimeTableRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(TableUiState())
    val uiState: StateFlow<TableUiState> = _uiState

    init {
        getWeeksAndTimes()
    }

    fun getWeeksAndTimes() {
        _uiState.update {
            it.copy(weeks = 5, times = 5)
        }
    }
}

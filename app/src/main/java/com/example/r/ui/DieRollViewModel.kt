package com.example.r.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DieUiState(
    val rollNumber: Int = 0,
    val rollCount: Int = 1
)

class DieRollViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DieUiState())
    val uiState: StateFlow<DieUiState> = _uiState.asStateFlow()

    fun rollClicked() {
        _uiState.update { currentState ->
            currentState.copy(
                rollNumber = (1..6).random(),
                rollCount = currentState.rollCount + 1
            )
        }
    }

}
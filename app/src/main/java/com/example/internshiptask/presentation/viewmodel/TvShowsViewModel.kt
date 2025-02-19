package com.example.internshiptask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshiptask.data.api.Repository
import com.example.internshiptask.presentation.state.ReleasesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TvShowsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReleasesUiState(isLoading = true)) // Set initial state as loading
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val repository = Repository()
            try {
                val result = repository.getReleases().filter { it.type.startsWith("tv") }
                _uiState.update {
                    it.copy(releases = result, isLoading = false) // Update state when data is loaded
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update { it.copy(isLoading = false) } // Stop loading on error
            }
        }
    }
}

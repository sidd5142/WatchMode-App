package com.example.internshiptask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshiptask.data.api.Repository
import com.example.internshiptask.presentation.state.ReleasesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReleasesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReleasesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val repository = Repository()
            try {
                val result = repository.getReleases()
                _uiState.update {
                    it.copy(releases = result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

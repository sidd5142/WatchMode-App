package com.example.internshiptask.presentation.state

import com.example.internshiptask.domain.Title

data class ReleasesUiState(
    val releases: List<Title> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null

)
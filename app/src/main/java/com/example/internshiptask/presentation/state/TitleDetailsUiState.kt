package com.example.internshiptask.presentation.state

import com.example.internshiptask.domain.Title

data class TitleDetailsUiState(
    val title: Title? = null,
    val isLoading: Boolean = true,
    val error: String? = null

)
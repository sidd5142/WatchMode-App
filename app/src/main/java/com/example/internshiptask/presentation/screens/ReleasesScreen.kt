package com.example.internshiptask.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.internshiptask.domain.Title
import com.example.internshiptask.domain.titlesSample
import com.example.internshiptask.presentation.compo.MovieGrid
import com.example.internshiptask.presentation.state.ReleasesUiState

@Composable
fun ReleasesScreen(
    uiState: ReleasesUiState,
    onMovieClick: (Title) -> Unit = {}
) {
    MovieGrid(
        uiState.releases,
        onMovieClick = onMovieClick
    )
}

@Preview(showBackground = true)
@Composable
private fun ReleasesScreenPreview() {
    ReleasesScreen(uiState = ReleasesUiState(releases = titlesSample)) // Corrected
}

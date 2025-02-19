package com.example.internshiptask.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.internshiptask.domain.Title
import com.example.internshiptask.domain.titlesSample
import com.example.internshiptask.presentation.compo.MovieGrid
import com.example.internshiptask.presentation.state.ReleasesUiState

@Composable
fun ReleasesScreen(
    uiState: ReleasesUiState,
    onMovieClick: (Title) -> Unit = {}
) {
    if (uiState.isLoading) {
        // Show a loader while data is loading
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    } else {
        // Show the actual movie grid when data is loaded
        MovieGrid(
            titles = uiState.releases,
            onMovieClick = onMovieClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReleasesScreenPreview() {
    ReleasesScreen(uiState = ReleasesUiState(releases = titlesSample, isLoading = true)) // Loader visible
}

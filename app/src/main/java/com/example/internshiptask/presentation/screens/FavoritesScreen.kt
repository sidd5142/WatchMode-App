package com.example.internshiptask.presentation.screens


import androidx.compose.runtime.Composable

//
//
//@Preview
//@Composable
//private fun FavoritesScreenPreview() {
//    FavoritesScreen()
//}
//
//@Composable
//fun FavoritesScreen() {
//    Text(text = "TV shows Loading :)")
//}


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.internshiptask.domain.Title
import com.example.internshiptask.presentation.compo.MovieGrid
import com.example.internshiptask.presentation.state.ReleasesUiState
import com.example.internshiptask.presentation.viewmodel.TvShowsViewModel
@Composable
fun FavoritesScreen(
    uiState: ReleasesUiState,
    viewModel: TvShowsViewModel = viewModel(),
    onMovieClick: (Title) -> Unit = {}
) {
//    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        // Show a loader while data is loading
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    } else {
        MovieGrid(
            titles = uiState.releases,
            onMovieClick = onMovieClick
        )
    }
}

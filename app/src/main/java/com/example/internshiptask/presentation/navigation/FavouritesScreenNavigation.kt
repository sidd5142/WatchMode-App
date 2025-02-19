package com.example.internshiptask.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.internshiptask.domain.Title
import com.example.internshiptask.presentation.screens.FavoritesScreen
import com.example.internshiptask.presentation.viewmodel.TvShowsViewModel

internal const val favoritesScreenRoute = "favorites"


fun NavGraphBuilder.favoritesScreen(
    onMovieClick: (Title) -> Unit
) {

    composable(favoritesScreenRoute) {
        val viewModel: TvShowsViewModel = viewModel<TvShowsViewModel>()
        val state = viewModel.uiState.collectAsState().value

        FavoritesScreen(
            uiState = state,
            onMovieClick = onMovieClick
        )
    }
}

fun NavController.navigateToFavoritesScreen(
    navOptions: NavOptions? = null
) {
    navigate(favoritesScreenRoute, navOptions)

}
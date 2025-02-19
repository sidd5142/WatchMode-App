package com.example.internshiptask.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

internal const val favoritesScreenRoute = "favorites"


fun NavGraphBuilder.favoritesScreen() {

    composable(favoritesScreenRoute) {
//        FavoritesScreen()
    }
}

fun NavController.navigateToFavoritesScreen(
    navOptions: NavOptions? = null
) {
    navigate(favoritesScreenRoute, navOptions)

}
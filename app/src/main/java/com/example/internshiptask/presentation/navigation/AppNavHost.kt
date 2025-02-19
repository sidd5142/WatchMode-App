package com.example.internshiptask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.example.internshiptask.presentation.compo.BottomAppBarItem
import navigateToTitleDetails
import titleDetailsScreen

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = releasesListNavigationRoutes
    ) {

        releasesListScreen(
            onMovieClick = {title ->
                navController.navigateToTitleDetails(title.id)
            }
        )


        favoritesScreen(
            onMovieClick = {title ->
                navController.navigateToTitleDetails(title.id)
            }
        )

        titleDetailsScreen<Any>(){
            //navController.popBackStack()
        }

    }

}


fun NavController.navigateSingleTopWithPopUpTo(
    item: BottomAppBarItem
) {
    val (route, navigate) = when (item) {
        BottomAppBarItem.Releases -> Pair(
            releasesListNavigationRoutes,
            ::navigateToReleasesList
        )

        BottomAppBarItem.Favorites -> Pair(
            favoritesScreenRoute,
            ::navigateToFavoritesScreen
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}
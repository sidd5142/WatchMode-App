package com.example.internshiptask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.internshiptask.domain.titlesSample
import com.example.internshiptask.presentation.compo.BottomAppBar
import com.example.internshiptask.presentation.compo.BottomAppBarItem
import com.example.internshiptask.presentation.compo.bottomAppBarItems
import com.example.internshiptask.presentation.navigation.AppNavHost
import com.example.internshiptask.presentation.navigation.favoritesScreenRoute
import com.example.internshiptask.presentation.navigation.navigateSingleTopWithPopUpTo
import com.example.internshiptask.presentation.navigation.releasesListNavigationRoutes
import com.example.internshiptask.presentation.screens.ReleasesScreen
import com.example.internshiptask.presentation.state.ReleasesUiState
import com.example.internshiptask.ui.theme.InternshipTaskTheme

//import com.example.internshiptask.domain.titlesSample


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination

            InternshipTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xFF2A2929)
                ) {
                    val currentRoute = currentDestination?.route
                    val selectedItem by remember(currentDestination) {

                        val item = when (currentRoute) {
                            releasesListNavigationRoutes -> BottomAppBarItem.Releases
                            favoritesScreenRoute -> BottomAppBarItem.Favorites
                            else -> BottomAppBarItem.Releases
                        }
                        mutableStateOf(item)
                    }

                    WatchModeApp(
                        isShowBottomBar = true,
                        isShowTopBar = true,
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = { item ->
                            navController.navigateSingleTopWithPopUpTo(item)
                        },
                        content = {
                            AppNavHost(navController = navController)
                        })
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchModeApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    isShowBottomBar: Boolean = false,
    isShowTopBar: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (isShowTopBar) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Moview")
                    },
                )
            }
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Moview")
                },
            )
        },
        bottomBar = {
            if (isShowBottomBar) {
                BottomAppBar(
                    item = bottomAppBarItemSelected,
                    items = bottomAppBarItems,
                    onItemChange = onBottomAppBarItemSelectedChange,
                )
            }
        },
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun WatchModeAppPreview() {
    InternshipTaskTheme {
        Surface {
            WatchModeApp(content = {
                ReleasesScreen(uiState = ReleasesUiState(releases = titlesSample))
            })
        }
    }
}
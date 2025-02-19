package com.example.internshiptask.presentation.compo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.internshiptask.ui.theme.InternshipTaskTheme

sealed class BottomAppBarItem(
    val label: String,
    val icon: ImageVector
) {
    object Releases : BottomAppBarItem(
        label = "Movies",
        icon = Icons.Filled.Home
    )

//    object Search : BottomAppBarItem(
//        label = "Search",
//        icon = Icons.Filled.Search
//    )

    object Favorites : BottomAppBarItem(
        label = "TV Shows",
        icon = Icons.Outlined.Star
    )

}

val bottomAppBarItems = listOf(
    BottomAppBarItem.Releases,
//    BottomAppBarItem.Search,
    BottomAppBarItem.Favorites
)

@Composable
fun BottomAppBar(
    item: BottomAppBarItem,
    modifier: Modifier = Modifier,
    items: List<BottomAppBarItem> = emptyList(),
    onItemChange: (BottomAppBarItem) -> Unit = {}
) {
    NavigationBar(modifier) {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = item.label == label,
                onClick = {
                    onItemChange(it)
                }
            )
        }
    }
}

@Preview
@Composable
fun PanucciBottomAppBarPreview() {
    InternshipTaskTheme{
        BottomAppBar(
            item = bottomAppBarItems.first(),
            items = bottomAppBarItems
        )
    }
}
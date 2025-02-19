package com.example.internshiptask.presentation.compo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.internshiptask.R
import com.example.internshiptask.domain.Title
import com.example.internshiptask.domain.titlesSample

@Composable
fun MoviesVerticalList(titles: List<Title>,
                       onTitleClick: (Title) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 4.dp),

        ) {

        items(titles.size) { i ->
            Column {
                Row(modifier = Modifier.clickable {
                    onTitleClick(titles[i])

                })
                {
                    AsyncImage(
                        modifier = Modifier.width(50.dp),
                        model = titles[i].poster,
                        contentScale = ContentScale.FillWidth,
                        placeholder = painterResource(id = R.drawable.placehold),
                        contentDescription = titles[i].title
                    )

                    Text(modifier = Modifier.padding(start = 4.dp), text = titles[i].title)
                }
                Box(modifier = Modifier.height(6.dp))
            }

        }
    }
}



@Preview
@Composable
private fun MoviesVerticalListPreview() {
    MoviesVerticalList(titles = titlesSample){}
}
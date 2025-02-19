package com.example.internshiptask.presentation.compo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.example.internshiptask.R
import com.example.internshiptask.domain.Title
import com.example.internshiptask.domain.titlesSample

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    title: Title,
    onMovieClick: (Title) -> Unit
) {
    AsyncImage(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onMovieClick(title)
            },
        model = title.poster,
        contentScale = ContentScale.FillWidth,
        error = painterResource( R.drawable.placehold),
        placeholder = painterResource(id = R.drawable.placehold),
        contentDescription = title.title
    )
}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        modifier = Modifier,
        title = titlesSample.first()
    ) {}
}
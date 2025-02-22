package com.example.internshiptask.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.internshiptask.R
import com.example.internshiptask.domain.titlesSample
import com.example.internshiptask.presentation.state.TitleDetailsUiState

@Preview
@Composable
private fun TitleDetailsScreenPreview() {
    TitleDetailsScreen(TitleDetailsUiState(title = titlesSample.first(), isLoading = true))
}

@Composable
fun TitleDetailsScreen(uiState: TitleDetailsUiState) {
    if (uiState.isLoading) {
        // Show a loader while data is loading
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    } else {
        uiState.title?.let { title ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        modifier = Modifier
                            .height(300.dp)
                            .align(Alignment.Center),
                        model = title.poster,
                        alignment = Alignment.Center,
                        placeholder = painterResource(id = R.drawable.placehold),
                        contentDescription = title.title
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 32.dp),
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                    text = "${title.title}  (${title.year})"
                )
                Text(
                    text = title.plot ?: "",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )

                Text(
                    text = ("Genres: " + title.genreNames?.joinToString(", ")),
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )

                title.userRating?.let {
                    Text(
                        text = ("Users Rating: " + title.userRating),
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                }

                title.year?.let {
                    Text(
                        text = ("Release Year: " + title.year),
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                }

                title.criticScore?.let {
                    Text(
                        text = ("Critics Rating: " + title.criticScore),
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                }
            }
        }
    }
}

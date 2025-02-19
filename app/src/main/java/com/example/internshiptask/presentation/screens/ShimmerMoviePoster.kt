package com.example.internshiptask.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.material3.placeholder

@Composable
fun ShimmerMoviePoster() {
    Card(
        modifier = Modifier
            .height(300.dp)
            .width(150.dp)
            .padding(4.dp)
            .placeholder(visible = true, shape = RoundedCornerShape(8.dp))
    ) {}
}

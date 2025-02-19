package com.example.internshiptask.data.api

import android.util.Log
import com.example.internshiptask.data.model.ReleaseSuccessResponse
import com.example.internshiptask.data.model.TitleDetailsSuccessResponse
import com.example.internshiptask.domain.Title


fun ReleaseSuccessResponse.Release.toTitle(): Title {
    Log.d("ImageURL", "Poster URL: $poster_url") // Debug Log to check API URL

    return Title(
        id = id,
        title = title,
        poster = poster_url?.takeIf { it.isNotBlank() }, // Ensures no empty strings
        plot = null,
        year = null,
        endYear = null,
        genreNames = null,
        userRating = null,
        criticScore = null,
        type = type,
    )
}



fun TitleDetailsSuccessResponse.toTitle(): Title {
    return Title(
        id = id,
        title = title,
        poster = poster,
        plot = plot_overview,
        year = year,
        endYear = end_year,
        genreNames = genre_names,
        userRating = user_rating,
        criticScore = critic_score,
        type = type,
    )
}



package com.example.internshiptask.data.api

import com.example.internshiptask.data.model.ReleaseSuccessResponse
import com.example.internshiptask.data.model.TitleDetailsSuccessResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WatchModeService {

    @GET("releases/")
    suspend fun getReleases(
        @Query("apiKey") apiKey: String
    ): ReleaseSuccessResponse


    @GET("title/{titleId}/details/")
    suspend fun getTitleDetails(
        @Path("titleId") titleId: Int,
        @Query("apiKey") apiKey: String
    ): TitleDetailsSuccessResponse


}
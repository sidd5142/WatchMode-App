package com.example.internshiptask.data.api

import com.example.internshiptask.domain.Title

class Repository {

    private val apiKey = "NfElWKdsoH8ZOm1nxsX3PVVg9OFrRo6Sy4jpesM7"
    private val service = watchModeApi.create(WatchModeService::class.java)

    suspend fun getReleases(): List<Title> {  // ✅ Changed List<Unit> to List<Title>
        return service.getReleases(apiKey).releases.map { it.toTitle() }
    }

    suspend fun getTitleDetails(titleId: Int): Title {
        return service.getTitleDetails(titleId, apiKey).toTitle()
    }
}

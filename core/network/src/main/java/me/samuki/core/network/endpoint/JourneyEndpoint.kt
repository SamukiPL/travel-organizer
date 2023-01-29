package me.samuki.core.network.endpoint

import me.samuki.core.network.model.request.ApiJourneyName
import me.samuki.core.network.model.ApiJourney

interface JourneyEndpoint {
    suspend fun createJourney(body: ApiJourneyName): ApiJourney

    suspend fun editName(body: ApiJourneyName): ApiJourney

    suspend fun getJourneys(): List<ApiJourney>

    suspend fun getDetails(journeyId: String): ApiJourney
}

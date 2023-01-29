package me.samuki.core.data.network

import me.samuki.core.network.endpoint.JourneyEndpoint
import me.samuki.core.network.model.request.ApiJourneyName
import javax.inject.Inject

class NetworkJourneyDataSource @Inject constructor(
    private val journeyEndpoint: JourneyEndpoint
) {
    suspend fun createJourney(name: String) = journeyEndpoint.createJourney(
        ApiJourneyName(
            name = name
        )
    )

    suspend fun editName(id: String, name: String) = journeyEndpoint.editName(
        ApiJourneyName(
            id = id,
            name = name
        )
    )

    suspend fun getSavableJourneys() = journeyEndpoint.getJourneys()

    suspend fun getJourneyDetails(journeyId: String) = journeyEndpoint.getDetails(journeyId)
}

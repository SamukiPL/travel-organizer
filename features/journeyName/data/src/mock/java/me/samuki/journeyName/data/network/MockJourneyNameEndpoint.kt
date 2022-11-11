package me.samuki.journeyName.data.network

import me.samuki.core.network.util.MockNetworkException
import me.samuki.journeyName.data.network.model.CreateJourneyResponse
import me.samuki.journeyName.data.network.model.EditNameResponse
import me.samuki.journeyName.data.network.model.JourneyNameRequest
import java.util.UUID
import javax.inject.Inject

class MockJourneyNameEndpoint @Inject constructor() : JourneyNameEndpoint {
    override fun createJourney(body: JourneyNameRequest): CreateJourneyResponse {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return CreateJourneyResponse(UUID.randomUUID().toString())
    }

    override fun editName(body: JourneyNameRequest): EditNameResponse {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return EditNameResponse(
            requireNotNull(body.id)
        )
    }
}

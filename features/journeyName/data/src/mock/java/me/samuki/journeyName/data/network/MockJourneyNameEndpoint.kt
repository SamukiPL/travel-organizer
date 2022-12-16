package me.samuki.journeyName.data.network

import kotlinx.datetime.toKotlinLocalDateTime
import me.samuki.core.network.util.MockNetworkException
import me.samuki.journeyName.data.network.model.JourneyNameRequest
import me.samuki.journeyName.data.network.model.JourneyNameResponse
import java.util.UUID
import javax.inject.Inject
import java.time.LocalDateTime as JavaLocalDateTime

internal class MockJourneyNameEndpoint @Inject constructor() : JourneyNameEndpoint {
    override fun createJourney(body: JourneyNameRequest): JourneyNameResponse {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return JourneyNameResponse(
            UUID.randomUUID().toString(),
            body.name,
            JavaLocalDateTime.now().toKotlinLocalDateTime()
        )
    }

    override fun editName(body: JourneyNameRequest): JourneyNameResponse {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return JourneyNameResponse(
            requireNotNull(body.id),
            body.name,
            JavaLocalDateTime.now().toKotlinLocalDateTime()
        )
    }
}

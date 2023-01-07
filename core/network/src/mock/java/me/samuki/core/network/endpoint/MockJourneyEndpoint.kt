package me.samuki.core.network.endpoint

import kotlinx.datetime.toKotlinLocalDateTime
import me.samuki.core.network.model.request.ApiJourneyName
import me.samuki.core.network.model.response.ApiJourney
import me.samuki.core.network.util.MockNetworkException
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject

class MockJourneyEndpoint @Inject constructor() : JourneyEndpoint {
    override suspend fun createJourney(body: ApiJourneyName): ApiJourney {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return ApiJourney(
            UUID.randomUUID().toString(),
            body.name,
            LocalDateTime.now().toKotlinLocalDateTime()
        )
    }

    override suspend fun editName(body: ApiJourneyName): ApiJourney {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return ApiJourney(
            requireNotNull(body.id),
            body.name,
            LocalDateTime.now().toKotlinLocalDateTime()
        )
    }

    override suspend fun getJourneys(): List<ApiJourney> {
        TODO("Not yet implemented")
    }
}

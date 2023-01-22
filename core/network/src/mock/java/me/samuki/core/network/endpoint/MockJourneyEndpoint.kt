package me.samuki.core.network.endpoint

import kotlinx.coroutines.delay
import kotlinx.datetime.toKotlinLocalDateTime
import me.samuki.core.network.model.request.ApiJourneyName
import me.samuki.core.network.model.response.ApiJourney
import me.samuki.core.network.util.MockNetworkException
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

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
        delay(Random.nextDouble(3.0, 7.0).seconds)
        return listOf(
            ApiJourney(
                id = "1317f7c8-18d6-405a-8be1-111111111111",
                name = "First Mocked One",
                lastRevision = LocalDateTime.now().toKotlinLocalDateTime()
            )
        )
    }
}

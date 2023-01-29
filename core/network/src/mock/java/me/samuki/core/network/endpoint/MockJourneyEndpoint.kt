package me.samuki.core.network.endpoint

import kotlinx.coroutines.delay
import kotlinx.datetime.toKotlinLocalDateTime
import me.samuki.core.database.JourneyQueries
import me.samuki.core.database.StageQueries
import me.samuki.core.network.model.request.ApiJourneyName
import me.samuki.core.network.model.ApiJourney
import me.samuki.core.network.model.ApiStage
import me.samuki.core.network.util.MockNetworkException
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class MockJourneyEndpoint @Inject constructor(
    private val journeyQueries: JourneyQueries,
    private val stageQueries: StageQueries
) : JourneyEndpoint {
    override suspend fun createJourney(body: ApiJourneyName): ApiJourney {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return ApiJourney(
            UUID.randomUUID().toString(),
            body.name,
            LocalDateTime.now().toKotlinLocalDateTime(),
            stages = null
        )
    }

    override suspend fun editName(body: ApiJourneyName): ApiJourney {
        if (body.name == "error") {
            throw MockNetworkException()
        }

        return ApiJourney(
            requireNotNull(body.id),
            body.name,
            LocalDateTime.now().toKotlinLocalDateTime(),
            stages = null
        )
    }

    override suspend fun getJourneys(): List<ApiJourney> {
        delay(Random.nextDouble(3.0, 7.0).seconds)
        return listOf(
            ApiJourney(
                id = "1317f7c8-18d6-405a-8be1-111111111111",
                name = "First Mocked One",
                lastRevision = LocalDateTime.now().toKotlinLocalDateTime(),
                stages = null
            )
        )
    }

    override suspend fun getDetails(journeyId: String): ApiJourney {
        delay(Random.nextDouble(3.0, 7.0).seconds)
        return journeyQueries.selectJourney(journeyId).executeAsOne().let {
            ApiJourney(
                id = it.id,
                name = it.name,
                lastRevision = it.lastRevision,
                stages = stageQueries.selectAllForJourney(journeyId).executeAsList()
                    .map { stage ->
                        ApiStage(
                            id = stage.id,
                            journeyId = stage.journeyId,
                            nextStageId = stage.nextStageId,
                            name = stage.name,
                            url = stage.url,
                            urlName = stage.urlName,
                            urlImage = stage.urlImage,
                            type = stage.type
                        )
                    }
            )
        }
    }
}

package me.samuki.core.network.endpoint

import kotlinx.coroutines.delay
import me.samuki.core.database.StageQueries
import me.samuki.core.database.entity.StorageStage
import me.samuki.core.network.model.ApiStage
import me.samuki.core.network.util.MockNetworkException
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class MockStageEndpoint @Inject constructor(
    private val stageQueries: StageQueries
) : StageEndpoint {
    override suspend fun getStagesForJourney(journeyId: String): List<ApiStage> {
        delay(Random.nextInt(2, 9).seconds)
        if (Random.nextInt(0, 50) == 42) {
            throw MockNetworkException()
        }

        return stageQueries.selectAllForJourney(journeyId = journeyId).executeAsList()
            .map {
                ApiStage(
                    id = it.id,
                    journeyId = it.journeyId,
                    nextStageId = it.nextStageId,
                    name = it.name,
                    url = it.url,
                    urlName = it.urlName,
                    urlImage = it.urlImage,
                    type = it.type
                )
            }
    }

    override suspend fun putStage(apiStage: ApiStage): ApiStage {
        if (apiStage.name == "error") throw MockNetworkException()

        val uuid = UUID.randomUUID().toString()

        stageQueries.upsertStage(
            StorageStage(
                id = uuid,
                journeyId = apiStage.journeyId,
                nextStageId = apiStage.nextStageId,
                name = apiStage.name,
                url = apiStage.url,
                urlName = apiStage.urlName,
                urlImage = apiStage.urlImage,
                type = apiStage.type
            )
        )
        return apiStage.copy(
            id = uuid
        )
    }

    override suspend fun deleteStage(stageId: String) {
        delay(Random.nextInt(1, 3).seconds)
    }
}

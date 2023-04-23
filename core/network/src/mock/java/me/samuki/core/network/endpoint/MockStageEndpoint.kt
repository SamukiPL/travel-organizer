package me.samuki.core.network.endpoint

import kotlinx.coroutines.delay
import me.samuki.core.data.mapper.toId
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

        return stageQueries.selectAllForJourney(journeyId = journeyId.toId()).executeAsList()
            .map {
                ApiStage(
                    id = it.id.toString(),
                    journeyId = it.journey_id.toString(),
                    nextStageId = it.next_stage_id?.toString(),
                    name = it.name,
                    url = it.url,
                    urlName = it.url_name,
                    urlImage = it.url_image,
                    type = it.type
                )
            }
    }

    override suspend fun putStage(apiStage: ApiStage): ApiStage {
        if (apiStage.name == "error") throw MockNetworkException()

        val uuid = UUID.randomUUID().toString().toId()

        stageQueries.upsertStage(
            StorageStage(
                id = uuid,
                journey_id = apiStage.journeyId.toId(),
                next_stage_id = apiStage.nextStageId?.toId(),
                name = apiStage.name,
                url = apiStage.url,
                url_name = apiStage.urlName,
                url_image = apiStage.urlImage,
                type = apiStage.type
            )
        )
        return apiStage.copy(
            id = uuid.toString()
        )
    }

    override suspend fun deleteStage(stageId: String) {
        delay(Random.nextInt(1, 3).seconds)
    }
}

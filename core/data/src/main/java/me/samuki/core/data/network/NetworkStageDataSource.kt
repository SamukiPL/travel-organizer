package me.samuki.core.data.network

import me.samuki.core.network.endpoint.StageEndpoint
import me.samuki.core.network.model.ApiStage
import javax.inject.Inject

class NetworkStageDataSource @Inject constructor(
    private val stageEndpoint: StageEndpoint
) {
    suspend fun putStage(apiStage: ApiStage): ApiStage = stageEndpoint.putStage(apiStage)

    suspend fun getStagesForJourney(journeyId: String): List<ApiStage> =
        stageEndpoint.getStagesForJourney(journeyId)

    suspend fun deleteStage(stageId: String) = stageEndpoint.deleteStage(stageId)
}

package me.samuki.core.network.endpoint

import me.samuki.core.network.model.ApiStage

interface StageEndpoint {
    suspend fun getStagesForJourney(journeyId: String): List<ApiStage>

    suspend fun putStage(apiStage: ApiStage): ApiStage

    suspend fun deleteStage(stageId: String)
}

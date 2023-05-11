package me.samuki.stageadd.data

import me.samuki.stageadd.data.mapper.toApi
import me.samuki.stageadd.domain.StageAddRepository
import me.samuki.stageadd.domain.NewStage
import me.samuki.core.data.ktx.returnResult
import me.samuki.core.data.local.LocalStageDataSource
import me.samuki.core.data.mapper.toId
import me.samuki.core.data.mapper.toStorage
import me.samuki.core.data.network.NetworkStageDataSource
import me.samuki.core.model.Id
import javax.inject.Inject

class DataStageAddRepository @Inject constructor(
    private val networkStageDataSource: NetworkStageDataSource,
    private val localStageDataSource: LocalStageDataSource
) : StageAddRepository {
    override suspend fun createStage(newStage: NewStage): Result<Id> = returnResult {
        val response = networkStageDataSource.putStage(newStage.toApi())

        localStageDataSource.saveStages(response.toStorage())
        localStageDataSource.addNextStageIdToLastStageInJourney(
            response.id!!.toId(),
            response.journeyId.toId()
        )
        requireNotNull(response.id).toId()
    }
}

package me.samuki.addstage.data

import me.samuki.addstage.data.mapper.toApi
import me.samuki.addstage.domain.AddStageRepository
import me.samuki.addstage.domain.NewStage
import me.samuki.core.data.ktx.returnResult
import me.samuki.core.data.local.LocalStageDataSource
import me.samuki.core.data.mapper.toId
import me.samuki.core.data.mapper.toStorage
import me.samuki.core.data.network.NetworkStageDataSource
import me.samuki.core.model.Id
import javax.inject.Inject

class DataAddStageRepository @Inject constructor(
    private val networkStageDataSource: NetworkStageDataSource,
    private val localStageDataSource: LocalStageDataSource
) : AddStageRepository {
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

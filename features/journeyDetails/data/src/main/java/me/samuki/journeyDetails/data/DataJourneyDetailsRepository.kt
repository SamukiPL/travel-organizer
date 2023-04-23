package me.samuki.journeyDetails.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import me.samuki.core.data.local.LocalJourneyDataSource
import me.samuki.core.data.local.LocalStageDataSource
import me.samuki.core.data.mapper.toDomain
import me.samuki.core.data.mapper.toId
import me.samuki.core.data.mapper.toStorage
import me.samuki.core.data.network.NetworkJourneyDataSource
import me.samuki.core.database.entity.StorageJourney
import me.samuki.core.database.entity.StorageStage
import me.samuki.core.network.model.ApiStage
import me.samuki.journeyDetails.domain.JourneyDetailsRepository
import me.samuki.journeyDetails.domain.model.JourneyDetails
import me.samuki.travel.common.util.ListResult
import javax.inject.Inject

class DataJourneyDetailsRepository @Inject constructor(
    private val networkJourney: NetworkJourneyDataSource,
    private val localJourney: LocalJourneyDataSource,
    private val localStage: LocalStageDataSource
) : JourneyDetailsRepository {
    override fun observeDetails(journeyId: String): Flow<Result<JourneyDetails>> =
        getJourneyFlow(journeyId)
            .combine(getStagesFlow(journeyId)) { journey, stages ->
                JourneyDetails(journey, stages)
            }
            .map { ListResult.success(it) }
            .catch { emit(ListResult.failure(it)) }

    override suspend fun syncJourney(journeyId: String) {
        networkJourney.getJourneyDetails(journeyId).let {
            localJourney.saveJourneys(it.toStorage())
            it.stages?.map(ApiStage::toStorage)
                ?.run {
                    localStage.saveStages(*toTypedArray())
                }
        }
    }

    private fun getJourneyFlow(journeyId: String) = localJourney.getJourney(journeyId.toId())
        .map(StorageJourney::toDomain)

    private fun getStagesFlow(journeyId: String) = localStage.getStagesForJourney(journeyId.toId())
        .map { it.map(StorageStage::toDomain) }
}

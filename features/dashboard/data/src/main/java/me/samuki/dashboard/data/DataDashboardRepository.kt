package me.samuki.dashboard.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import me.samuki.core.data.local.LocalJourneyDataSource
import me.samuki.core.data.local.LocalStageDataSource
import me.samuki.core.data.mapper.toDomain
import me.samuki.core.data.mapper.toStorage
import me.samuki.core.data.network.NetworkJourneyDataSource
import me.samuki.core.database.entity.StorageJourney
import me.samuki.core.domain.model.Journey
import me.samuki.core.network.model.ApiJourney
import me.samuki.core.network.model.ApiStage
import me.samuki.dashboard.domain.DashboardRepository
import me.samuki.travel.common.util.ListResult
import javax.inject.Inject


class DataDashboardRepository @Inject constructor(
    private val network: NetworkJourneyDataSource,
    private val local: LocalJourneyDataSource,
    private val localStage: LocalStageDataSource
) : DashboardRepository {

    override fun observeJourneys(): Flow<ListResult<Journey>> =
        local.getJourneys()
            .map { it.map(StorageJourney::toDomain) }
            .map { Result.success(it) }
            .catch { emit(Result.failure(it)) }

    override suspend fun syncJourneys() {
        network.getSavableJourneys()
            .also { journeys ->
                saveStages(journeys.flatMap { it.stages.orEmpty() })
            }
            .map(ApiJourney::toStorage)
            .run {
                local.saveJourneys(*toTypedArray())
            }
    }

    private suspend fun saveStages(stages: List<ApiStage>) {
        supervisorScope {
            launch {
                stages.map(ApiStage::toStorage)
                    .run {
                        localStage.saveStages(*toTypedArray())
                    }
            }
        }
    }
}

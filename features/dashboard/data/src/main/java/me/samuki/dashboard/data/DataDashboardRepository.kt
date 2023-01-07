package me.samuki.dashboard.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import me.samuki.core.data.local.LocalJourneyDataSource
import me.samuki.core.data.mapper.toDomain
import me.samuki.core.data.mapper.toStorage
import me.samuki.core.data.network.NetworkJourneyDataSource
import me.samuki.core.database.entity.StorageJourney
import me.samuki.core.domain.model.Journey
import me.samuki.core.network.model.response.ApiJourney
import me.samuki.dashboard.domain.DashboardRepository
import me.samuki.travel.common.util.ListResult
import javax.inject.Inject

class DataDashboardRepository @Inject constructor(
    private val network: NetworkJourneyDataSource,
    private val local: LocalJourneyDataSource
) : DashboardRepository {
    override fun observeJourneys(): Flow<ListResult<Journey>> = local.getJourneys().onStart {
        network.getSavableJourneys()
            .map(ApiJourney::toStorage)
            .also {
                local.saveJourneys(*it.toTypedArray())
            }
    }
        .map { it.map(StorageJourney::toDomain) }
        .map { Result.success(it) }
        .catch { emit(Result.failure(it)) }
}

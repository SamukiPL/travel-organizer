package me.samuki.dashboard.domain

import kotlinx.coroutines.flow.Flow
import me.samuki.core.domain.model.Journey
import me.samuki.travel.common.util.ListResult

interface DashboardRepository {
    fun observeJourneys(): Flow<ListResult<Journey>>

    suspend fun syncJourneys()
}

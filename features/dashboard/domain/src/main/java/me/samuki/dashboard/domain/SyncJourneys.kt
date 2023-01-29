package me.samuki.dashboard.domain

import kotlinx.coroutines.withContext
import me.samuki.core.domain.di.IoCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SyncJourneys @Inject constructor(
    private val dashboardRepository: DashboardRepository,
    @IoCoroutineContext private val coroutineContext: CoroutineContext
){
    suspend operator fun invoke() = withContext(coroutineContext) {
        dashboardRepository.syncJourneys()
    }

}

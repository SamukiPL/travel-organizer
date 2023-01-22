package me.samuki.dashboard.domain

import javax.inject.Inject

class ObserveJourneys @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {
    operator fun invoke() = dashboardRepository.observeJourneys()
}

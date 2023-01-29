package me.samuki.journeyDetails.domain

import javax.inject.Inject

class ObserveJourneyDetails @Inject constructor(
    private val journeyDetailsRepository: JourneyDetailsRepository
) {
    operator fun invoke(journeyId: String) = journeyDetailsRepository.observeDetails(journeyId)
}

package me.samuki.journeyDetails.domain

import kotlinx.coroutines.flow.Flow
import me.samuki.journeyDetails.domain.model.JourneyDetails

interface JourneyDetailsRepository {
    fun observeDetails(journeyId: String): Flow<Result<JourneyDetails>>

    suspend fun syncJourney(journeyId: String)
}

package me.samuki.journeyDetails.domain

import kotlinx.coroutines.withContext
import me.samuki.core.domain.di.IoCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SyncJourneyDetails @Inject constructor(
    private val journeyDetailsRepository: JourneyDetailsRepository,
    @IoCoroutineContext private val coroutineContext: CoroutineContext
){
    suspend operator fun invoke(journeyId: String) = withContext(coroutineContext) {
        journeyDetailsRepository.syncJourney(journeyId)
    }
}

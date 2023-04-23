package me.samuki.core.data.local

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import kotlinx.coroutines.flow.Flow
import me.samuki.core.database.JourneyQueries
import me.samuki.core.database.entity.StorageJourney
import me.samuki.core.model.Id
import javax.inject.Inject

class LocalJourneyDataSource @Inject constructor(
    private val journeyQueries: JourneyQueries
) {
    fun saveJourneys(vararg journeys: StorageJourney) {
        journeyQueries.transaction {
            journeys.forEach {
                journeyQueries.upsertJourney(it)
            }
        }
    }

    fun getJourneys(): Flow<List<StorageJourney>> = journeyQueries.selectAll()
        .asFlow()
        .mapToList()

    fun getJourney(journeyId: Id): Flow<StorageJourney> = journeyQueries.selectJourney(journeyId)
        .asFlow()
        .mapToOne()
}

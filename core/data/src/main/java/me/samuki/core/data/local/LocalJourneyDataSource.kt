package me.samuki.core.data.local

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import me.samuki.core.database.JourneyQueries
import me.samuki.core.database.entity.StorageJourney
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

    fun getJourneys() = journeyQueries.selectAll()
        .asFlow()
        .mapToList()

}

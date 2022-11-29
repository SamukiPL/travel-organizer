package me.samuki.journeyName.data.mappers

import me.samuki.core.database.entity.StorageJourney
import me.samuki.journeyName.data.network.model.JourneyNameResponse
import javax.inject.Inject

internal class ResponseToStorageJourneyMapper @Inject constructor() {
    fun toStorage(response: JourneyNameResponse) = StorageJourney(
        id = response.id,
        name = response.name,
        lastRevision = response.lastRevision
    )
}

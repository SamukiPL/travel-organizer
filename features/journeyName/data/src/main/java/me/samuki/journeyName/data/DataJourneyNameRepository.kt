package me.samuki.journeyName.data

import me.samuki.core.database.JourneyQueries
import me.samuki.journeyName.data.mappers.ResponseToStorageJourneyMapper
import me.samuki.journeyName.data.network.JourneyNameEndpoint
import me.samuki.journeyName.data.network.model.JourneyNameRequest
import me.samuki.journeyName.domain.JourneyNameRepository
import javax.inject.Inject

internal class DataJourneyNameRepository @Inject constructor(
    private val endpoint: JourneyNameEndpoint,
    private val databaseMapper: ResponseToStorageJourneyMapper,
    private val journeyQueries: JourneyQueries
) : JourneyNameRepository {
    override suspend fun createOrUpdateName(id: String?, name: String): Result<String> {
        return try {
            val response = id?.run {
                endpoint.editName(JourneyNameRequest(id, name = name))
            } ?: endpoint.createJourney(JourneyNameRequest(name = name))

            journeyQueries.upsertJourney(databaseMapper.toStorage(response))
            Result.success(response.id)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}

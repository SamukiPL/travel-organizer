package me.samuki.journeyName.data

import me.samuki.core.data.local.LocalJourneyDataSource
import me.samuki.core.data.mapper.toStorage
import me.samuki.core.data.network.NetworkJourneyDataSource
import me.samuki.journeyName.domain.JourneyNameRepository
import javax.inject.Inject

internal class DataJourneyNameRepository @Inject constructor(
    private val network: NetworkJourneyDataSource,
    private val local: LocalJourneyDataSource
) : JourneyNameRepository {
    override suspend fun createOrUpdateName(id: String?, name: String): Result<String> {
        return try {
            val response = id?.run {
                network.editName(id, name = name)
            } ?: network.createJourney(name = name)

            local.saveJourneys(response.toStorage())
            Result.success(response.id)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}

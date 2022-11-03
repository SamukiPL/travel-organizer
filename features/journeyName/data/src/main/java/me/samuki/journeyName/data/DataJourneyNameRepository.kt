package me.samuki.journeyName.data

import me.samuki.journeyName.data.network.JourneyNameEndpoint
import me.samuki.journeyName.data.network.model.JourneyNameRequest
import me.samuki.journeyName.domain.JourneyNameRepository
import javax.inject.Inject

class DataJourneyNameRepository @Inject constructor(
    private val endpoint: JourneyNameEndpoint
) : JourneyNameRepository {
    override suspend fun createNewJourney(name: String): Result<String> {
        return try {
            val request = JourneyNameRequest(name = name)
            val response = endpoint.createJourney(request)
            Result.success(response.id)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    override suspend fun editJourneyName(id: String, name: String): Result<String> {
        return try {
            val request = JourneyNameRequest(id = id, name = name)
            val response = endpoint.editName(request)
            Result.success(response.id)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}

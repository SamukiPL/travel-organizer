package me.samuki.journeyName.domain

interface JourneyNameRepository {
    suspend fun createOrUpdateName(id: String?, name: String): Result<String>
}

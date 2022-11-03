package me.samuki.journeyName.domain

interface JourneyNameRepository {
    suspend fun createNewJourney(name: String): Result<String>
    suspend fun editJourneyName(id: String, name: String): Result<String>
}

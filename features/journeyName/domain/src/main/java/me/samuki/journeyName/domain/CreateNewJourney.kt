package me.samuki.journeyName.domain

import javax.inject.Inject

class CreateNewJourney @Inject constructor(private val repository: JourneyNameRepository) {
    suspend operator fun invoke(name: String) = repository.createNewJourney(name)
}

package me.samuki.journeyName.domain

import javax.inject.Inject

class EditJourneyName @Inject constructor(private val repository: JourneyNameRepository) {
    suspend operator fun invoke(id: String, name: String) = repository.editJourneyName(id, name)
}

package me.samuki.journeyName.domain

import javax.inject.Inject

class CreateOrUpdateName @Inject constructor(private val repository: JourneyNameRepository) {
    suspend operator fun invoke(id: String?, name: String) = repository.createOrUpdateName(id, name)
}

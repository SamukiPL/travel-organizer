package me.samuki.journeyName.domain

import kotlinx.coroutines.withContext
import me.samuki.core.domain.di.IoCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CreateOrUpdateName @Inject constructor(
    private val repository: JourneyNameRepository,
    @IoCoroutineContext private val context: CoroutineContext
) {
    suspend operator fun invoke(id: String?, name: String) = withContext(context) {
        repository.createOrUpdateName(id, name)
    }
}

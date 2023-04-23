package me.samuki.addstage.domain

import kotlinx.coroutines.withContext
import me.samuki.core.domain.di.IoCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CreateStage @Inject constructor(
    private val addStageRepository: AddStageRepository,
    @IoCoroutineContext private val coroutineContext: CoroutineContext
)  {
    suspend operator fun invoke(newStage: NewStage) = withContext(coroutineContext) {
        addStageRepository.createStage(newStage)
    }
}

package me.samuki.stageadd.domain

import kotlinx.coroutines.withContext
import me.samuki.core.domain.di.IoCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CreateStage @Inject constructor(
    private val stageAddRepository: StageAddRepository,
    @IoCoroutineContext private val coroutineContext: CoroutineContext
)  {
    suspend operator fun invoke(newStage: NewStage) = withContext(coroutineContext) {
        stageAddRepository.createStage(newStage)
    }
}

package me.samuki.addstage.domain

import me.samuki.core.model.Id

interface AddStageRepository {
    suspend fun createStage(newStage: NewStage): Result<Id>
}

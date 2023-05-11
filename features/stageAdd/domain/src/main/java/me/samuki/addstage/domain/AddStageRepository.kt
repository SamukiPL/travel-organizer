package me.samuki.stageadd.domain

import me.samuki.core.model.Id

interface StageAddRepository {
    suspend fun createStage(newStage: NewStage): Result<Id>
}

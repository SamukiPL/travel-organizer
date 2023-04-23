package me.samuki.core.domain.model

import me.samuki.core.model.Id
import me.samuki.core.model.StageType

data class Stage(
    val id: Id,
    val journeyId: Id,
    val nextStageId: Id?,
    val name: String,
    val url: String,
    val urlName: String?,
    val urlImage: String?,
    val type: StageType
)

package me.samuki.core.domain.model

import me.samuki.core.model.StageType

data class Stage(
    val id: String,
    val journeyId: String,
    val nextStageId: String?,
    val name: String,
    val url: String,
    val urlName: String?,
    val urlImage: String?,
    val type: StageType
)

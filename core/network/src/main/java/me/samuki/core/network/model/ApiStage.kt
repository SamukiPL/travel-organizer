package me.samuki.core.network.model

import kotlinx.serialization.Serializable
import me.samuki.core.model.StageType

@Serializable
data class ApiStage(
    val id: String?,
    val journeyId: String,
    val nextStageId: String?,
    val name: String,
    val url: String,
    val urlName: String?,
    val urlImage: String?,
    val type: StageType
)

package me.samuki.addstage.domain

import me.samuki.core.model.Id
import me.samuki.core.model.StageType

data class NewStage(
    val journeyId: Id,
    val name: String,
    val type: StageType,
    val url: String,
    val urlName: String?,
    val urlImage: String?,
)

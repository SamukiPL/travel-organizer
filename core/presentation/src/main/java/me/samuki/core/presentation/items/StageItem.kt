package me.samuki.core.presentation.items

import me.samuki.core.domain.model.Stage
import me.samuki.core.model.Id
import me.samuki.core.model.StageType

data class StageItem(
    val id: Id,
    val journeyId: Id,
    val nextStageId: Id?,
    val name: String,
    val url: String,
    val urlName: String?,
    val urlImage: String?,
    val type: StageType
)

fun Stage.toItem() = StageItem(
    id = id,
    journeyId = journeyId,
    nextStageId = nextStageId,
    name = name,
    url = url,
    urlName = urlName,
    urlImage = urlImage,
    type = type
)

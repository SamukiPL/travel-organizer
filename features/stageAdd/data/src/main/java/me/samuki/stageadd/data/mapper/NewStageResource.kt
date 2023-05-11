package me.samuki.stageadd.data.mapper

import me.samuki.stageadd.domain.NewStage
import me.samuki.core.network.model.ApiStage

fun NewStage.toApi() = ApiStage(
    id = null,
    journeyId = journeyId.toString(),
    nextStageId = null,
    name = name,
    url = url,
    urlName = urlName,
    urlImage = urlImage,
    type = type
)

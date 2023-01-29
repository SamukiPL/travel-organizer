package me.samuki.core.data.mapper

import me.samuki.core.database.entity.StorageStage
import me.samuki.core.domain.model.Stage
import me.samuki.core.network.model.ApiStage

fun ApiStage.toStorage() = StorageStage(
    id = requireNotNull(id) {
        "Id returned from api, can't be null"
    },
    journeyId = journeyId,
    nextStageId = nextStageId,
    name = name,
    url = url,
    urlName = urlName,
    urlImage = urlImage,
    type = type
)

fun Stage.toApi() = ApiStage(
    id = id.ifEmpty { null },
    journeyId = journeyId,
    nextStageId = nextStageId,
    name = name,
    url = url,
    urlName = urlName,
    urlImage = urlImage,
    type = type
)

fun StorageStage.toDomain() = Stage(
    id = id,
    journeyId = journeyId,
    nextStageId = nextStageId,
    name = name,
    url = url,
    urlName = urlName,
    urlImage = urlImage,
    type = type
)

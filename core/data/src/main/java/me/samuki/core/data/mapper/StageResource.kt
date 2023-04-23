package me.samuki.core.data.mapper

import me.samuki.core.database.entity.StorageStage
import me.samuki.core.domain.model.Stage
import me.samuki.core.network.model.ApiStage

fun ApiStage.toStorage() = StorageStage(
    id = requireNotNull(id?.toId()) {
        "Id returned from api, can't be null"
    },
    journey_id = journeyId.toId(),
    next_stage_id = nextStageId?.toId(),
    name = name,
    url = url,
    url_name = urlName,
    url_image = urlImage,
    type = type
)

fun Stage.toApi() = ApiStage(
    id = id.toString().ifEmpty { null },
    journeyId = journeyId.toString(),
    nextStageId = nextStageId?.toString(),
    name = name,
    url = url,
    urlName = urlName,
    urlImage = urlImage,
    type = type
)

fun StorageStage.toDomain() = Stage(
    id = id,
    journeyId = journey_id,
    nextStageId = next_stage_id,
    name = name,
    url = url,
    urlName = url_name,
    urlImage = url_image,
    type = type
)

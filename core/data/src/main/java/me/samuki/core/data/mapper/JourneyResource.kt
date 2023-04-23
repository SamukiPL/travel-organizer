package me.samuki.core.data.mapper

import me.samuki.core.database.entity.StorageJourney
import me.samuki.core.domain.model.Journey
import me.samuki.core.network.model.ApiJourney

fun ApiJourney.toDomain() = Journey(
    id = id.toId(),
    name = name,
    lastRevision = lastRevision
)

fun ApiJourney.toStorage() = StorageJourney(
    id = id.toId(),
    name = name,
    last_revision = lastRevision
)

fun StorageJourney.toDomain() = Journey(
    id = id,
    name = name,
    lastRevision = last_revision
)

package me.samuki.journeyName.data.network.model

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer
import kotlinx.serialization.Serializable

@Serializable
class JourneyNameResponse(
    val id: String,
    val name: String,
    @Serializable(LocalDateTimeIso8601Serializer::class) val lastRevision: LocalDateTime
)

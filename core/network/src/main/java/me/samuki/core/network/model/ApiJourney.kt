package me.samuki.core.network.model

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer
import kotlinx.serialization.Serializable

@Serializable
data class ApiJourney(
    val id: String,
    val name: String,
    @Serializable(LocalDateTimeIso8601Serializer::class) val lastRevision: LocalDateTime,
    val stages: List<ApiStage>?
)

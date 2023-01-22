package me.samuki.core.network.model.request

import kotlinx.serialization.Serializable

@Serializable
class ApiJourneyName(
    val id: String? = null,
    val name: String
)

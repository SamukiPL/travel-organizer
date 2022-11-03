package me.samuki.journeyName.data.network.model

@kotlinx.serialization.Serializable
class JourneyNameRequest(
    val id: String? = null,
    val name: String
)

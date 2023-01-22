package me.samuki.core.presentation.items

import me.samuki.core.domain.model.Journey

data class JourneyItem(
    val id: String,
    val name: String
)

/**
 * To avoid recomposition, every model from non-compose Module
 * has to be mapped to compose one.
 */
fun Journey.toItem() = JourneyItem(
    id = id,
    name = name
)

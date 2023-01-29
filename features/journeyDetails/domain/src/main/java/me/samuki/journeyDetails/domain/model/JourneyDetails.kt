package me.samuki.journeyDetails.domain.model

import me.samuki.core.domain.model.Journey
import me.samuki.core.domain.model.Stage

data class JourneyDetails(
    val journey: Journey,
    val stages: List<Stage>
)

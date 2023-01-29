package me.samuki.journeyDetails.presentation.states

import me.samuki.core.presentation.items.StageItem

internal sealed interface JourneyDetailsState {
    object Loading: JourneyDetailsState
    object Empty: JourneyDetailsState
    data class Content(
        val items: List<StageItem>
    ): JourneyDetailsState
    object Error: JourneyDetailsState
}

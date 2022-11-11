package me.samuki.journeyDetails.presentation.states

sealed interface JourneyDetailsState {
    object Loading: JourneyDetailsState
    object Empty: JourneyDetailsState
    object Content: JourneyDetailsState
    object Error: JourneyDetailsState
}

package me.samuki.journeyDetails.presentation

interface JourneyDetailsNavigation {
    fun getJourneyDetailsIdArgument(): String

    fun goToAddNewStage(journeyId: String)
}

package me.samuki.journeyName.presentation

interface JourneyNameNavigation {
    fun getJourneyNameNameArgument(): String?
    fun getJourneyNameIdArgument(): String?

    fun goToDetails(id: String)
}

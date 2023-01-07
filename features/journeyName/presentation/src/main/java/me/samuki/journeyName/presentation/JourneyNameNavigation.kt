package me.samuki.journeyName.presentation

import me.samuki.core.presentation.navigation.GoBackNavigation

interface JourneyNameNavigation : GoBackNavigation {
    fun getJourneyNameNameArgument(): String?
    fun getJourneyNameIdArgument(): String?

    fun goToDetails(id: String)
}

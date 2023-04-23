package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.journeyDetails.presentation.JourneyDetailsNavigation
import me.samuki.navigation.destinations.AddStage
import me.samuki.navigation.destinations.JourneyDetails
import me.samuki.navigation.ext.getString

internal class ProvidedJourneyDetailsNavigation(private val navController: NavController) :
    JourneyDetailsNavigation {
    override fun getJourneyDetailsIdArgument(): String =
        requireNotNull(navController.getString(JourneyDetails.idArgument))

    override fun goToAddNewStage(journeyId: String) {
        navController.navigate(AddStage.createRoute(journeyId)) {
            popUpTo(requireNotNull(navController.currentDestination?.route)) {
                inclusive = false
            }
        }
    }
}

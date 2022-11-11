package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.journeyName.presentation.JourneyNameNavigation
import me.samuki.navigation.destinations.EditJourneyName
import me.samuki.navigation.destinations.JourneyDetails
import me.samuki.navigation.ext.getString

internal class ProvidedJourneyNameNavigation(
    private val navController: NavController
) : JourneyNameNavigation {
    override fun getJourneyNameNameArgument(): String? = navController.getString(EditJourneyName.nameArgument)

    override fun getJourneyNameIdArgument(): String? = navController.getString(EditJourneyName.idArgument)

    override fun goToDetails(id: String) {
        val route = JourneyDetails.createRoute(id)
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(requireNotNull(navController.currentDestination?.route)) {
                inclusive = true
            }
        }
    }
}

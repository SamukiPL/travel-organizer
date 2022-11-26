package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.addstage.presentation.AddStageNavigation
import me.samuki.navigation.destinations.JourneyDetails

class ProvidedAddStageNavigation(private val navController: NavController) : AddStageNavigation {
    override fun returnToDetails() {
        val route = JourneyDetails.createRoute("id")
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(requireNotNull(navController.currentDestination?.route)) {
                inclusive = true
            }
        }
    }
}

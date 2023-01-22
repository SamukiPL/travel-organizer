package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.dashboard.presentation.DashboardNavigation
import me.samuki.navigation.destinations.JourneyDetails
import me.samuki.navigation.destinations.AddJourney

class ProvidedDashboardNavigation(private val navController: NavController) : DashboardNavigation {
    override fun goToJourney(id: String) {
        navController.navigate(JourneyDetails.createRoute(id)) {
            launchSingleTop = true
            popUpTo(requireNotNull(navController.currentDestination?.route)) {
                inclusive = false
            }
        }
    }

    override fun goToAddJourney() {
        navController.navigate(AddJourney.createRoute()) {
            launchSingleTop = true
            popUpTo(requireNotNull(navController.currentDestination?.route)) {
                inclusive = false
            }
        }
    }
}

package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.navigation.destinations.Dashboard
import me.samuki.navigation.destinations.JourneyName
import me.samuki.onboarding.OnBoardingNavigation

internal class ProvidedOnBoardingNavigation(private val navController: NavController) :
    OnBoardingNavigation {
    override fun createNewJourney() {
        val route = JourneyName.createRoute()
        navController.navigate(route) {
            popUpTo(Dashboard.route) {
                inclusive = false
            }
        }
    }
}

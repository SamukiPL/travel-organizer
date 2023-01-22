package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.navigation.destinations.Dashboard
import me.samuki.navigation.destinations.AddJourney
import me.samuki.onboarding.OnBoardingNavigation

internal class ProvidedOnBoardingNavigation(private val navController: NavController) :
    OnBoardingNavigation {
    override fun createNewJourney() {
        val route = AddJourney.createRoute()
        navController.navigate(route) {
            popUpTo(Dashboard.route) {
                inclusive = false
            }
        }
    }
}

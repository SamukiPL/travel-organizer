package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.onboarding.OnBoardingNavigation

internal class ProvidedOnBoardingNavigation(private val navController: NavController) : OnBoardingNavigation {
    override fun createNewJourney() {

    }
}

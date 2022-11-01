package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.journeyDetails.presentation.JourneyDetailsNavigation
import me.samuki.onboarding.OnBoardingNavigation

class AppNavigation(
    navController: NavController
) : OnBoardingNavigation by ProvidedOnBoardingNavigation(navController),
    JourneyDetailsNavigation by ProvidedJourneyDetailsNavigation(navController)

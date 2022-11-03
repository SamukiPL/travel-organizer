package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.journeyDetails.presentation.JourneyDetailsNavigation
import me.samuki.journeyName.presentation.JourneyNameNavigation
import me.samuki.onboarding.OnBoardingNavigation

class AppNavigation(
    navController: NavController
) : OnBoardingNavigation by ProvidedOnBoardingNavigation(navController),
    JourneyNameNavigation by ProvidedJourneyNameNavigation(navController),
    JourneyDetailsNavigation by ProvidedJourneyDetailsNavigation(navController)

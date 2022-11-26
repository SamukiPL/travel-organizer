package me.samuki.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation.NavController
import me.samuki.addstage.presentation.AddStageNavigation
import me.samuki.journeyDetails.presentation.JourneyDetailsNavigation
import me.samuki.journeyName.presentation.JourneyNameNavigation
import me.samuki.onboarding.OnBoardingNavigation

@Immutable
class AppNavigation(
    navController: NavController
) : OnBoardingNavigation by ProvidedOnBoardingNavigation(navController),
    JourneyNameNavigation by ProvidedJourneyNameNavigation(navController),
    JourneyDetailsNavigation by ProvidedJourneyDetailsNavigation(navController),
    AddStageNavigation by ProvidedAddStageNavigation(navController)

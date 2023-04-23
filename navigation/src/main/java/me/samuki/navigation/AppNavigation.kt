package me.samuki.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation.NavController
import me.samuki.addstage.presentation.AddStageNavigation
import me.samuki.core.presentation.navigation.GoBackNavigation
import me.samuki.dashboard.presentation.DashboardNavigation
import me.samuki.journeyDetails.presentation.JourneyDetailsNavigation
import me.samuki.journeyName.presentation.JourneyNameNavigation
import me.samuki.onboarding.OnBoardingNavigation

@Immutable
class AppNavigation(
    navController: NavController
) : OnBoardingNavigation by ProvidedOnBoardingNavigation(navController),
    DashboardNavigation by ProvidedDashboardNavigation(navController),
    JourneyNameNavigation by ProvidedJourneyNameNavigation(navController),
    JourneyDetailsNavigation by ProvidedJourneyDetailsNavigation(navController),
    AddStageNavigation by ProvidedAddStageNavigation(navController),
    GoBackNavigation by ProvidedGoBackNavigation(navController)

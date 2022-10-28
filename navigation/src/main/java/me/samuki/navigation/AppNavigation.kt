package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.onboarding.OnBoardingNavigation

class AppNavigation(
    navController: NavController
) : OnBoardingNavigation by ProvidedOnBoardingNavigation(navController)

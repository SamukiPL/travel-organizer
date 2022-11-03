package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import me.samuki.navigation.AppNavigation
import me.samuki.onboarding.OnBoardingScreen
import javax.inject.Inject

internal class OnBoarding @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = emptyList()

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        OnBoardingScreen(navigation)
    }

    companion object {
        const val route = "onboarding"
    }
}

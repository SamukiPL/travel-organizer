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
    override fun BuildDestination(navigation: AppNavigation, screenTitle: (String?) -> Unit) {
        OnBoardingScreen(navigation)
        screenTitle(null)
    }

    companion object {
        const val route = "onboarding"
    }
}

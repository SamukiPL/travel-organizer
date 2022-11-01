package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import me.samuki.journeyDetails.presentation.JourneyDetailsScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

internal class JourneyDetails @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = emptyList()

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        JourneyDetailsScreen(journeyDetailsNavigation = navigation)
    }

    companion object {
        private const val route = "journeyDetails"


    }
}

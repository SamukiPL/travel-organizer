package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import me.samuki.journeyName.presentation.JourneyNameScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

class JourneyName @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = emptyList()

    @Composable
    override fun BuildDestination(navigation: AppNavigation, screenTitle: (String?) -> Unit) {
        screenTitle(JourneyNameScreen(navigation = navigation))
    }

    companion object {
        private const val route = "journeyName"

        fun createRoute() = route
    }
}

package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import me.samuki.journeyDetails.presentation.JourneyDetailsScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

internal class JourneyDetails @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(idArgument) {
                type = NavType.StringType
            }
        )

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        JourneyDetailsScreen(journeyDetailsNavigation = navigation)
    }

    companion object {
        private const val journeyDetails = "journeyDetails"
        const val idArgument = "id"
        private const val route = "$journeyDetails?$idArgument={$idArgument}"

        fun createRoute(id: String) = "$journeyDetails?$idArgument=$id"
    }
}

package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import me.samuki.journeyDetails.presentation.JourneyDetailsScreen
import me.samuki.navigation.AppNavigation
import java.util.UUID
import javax.inject.Inject

@Immutable
internal class JourneyDetails @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(idArgument) {
                type = NavType.StringType
                defaultValue = UUID.randomUUID().toString()
            }
        )

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        JourneyDetailsScreen(journeyDetailsNavigation = navigation, goBackNavigation = navigation)
    }

    companion object {
        private const val journeyDetails = "journeyDetails"
        const val idArgument = "id"
        const val route = "$journeyDetails?$idArgument={$idArgument}"

        fun createRoute(id: String) = "$journeyDetails?$idArgument=$id"
    }
}

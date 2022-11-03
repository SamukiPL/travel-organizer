package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import me.samuki.journeyName.presentation.JourneyNameScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

class JourneyName @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(idArgument) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(nameArgument) {
                type = NavType.StringType
                nullable = true
            }
        )

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        JourneyNameScreen(navigation = navigation)
    }

    companion object {
        private const val journeyName = "journeyName"
        const val idArgument = "id"
        const val nameArgument = "name"
        const val route = "$journeyName?$idArgument={$idArgument}&$nameArgument={$nameArgument}"

        fun newJourneyRoute() = journeyName
        fun createEditRoute(id: String? = null, name: String? = null) = "$journeyName?$idArgument=$id&$nameArgument=$name"
    }
}

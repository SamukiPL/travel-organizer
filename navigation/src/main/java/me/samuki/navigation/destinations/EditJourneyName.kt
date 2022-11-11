package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import me.samuki.journeyName.presentation.JourneyNameScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

class EditJourneyName @Inject constructor() : Destination {
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
    override fun BuildDestination(navigation: AppNavigation, screenTitle: (String?) -> Unit) {
        screenTitle(JourneyNameScreen(navigation = navigation))
    }

    companion object {
        private const val editJourneyName = "editJourneyName"
        const val idArgument = "id"
        const val nameArgument = "name"
        const val route = "$editJourneyName?$idArgument={$idArgument}&$nameArgument={$nameArgument}"

        fun createEditRoute(id: String? = null, name: String? = null) =
            "$editJourneyName?$idArgument=$id&$nameArgument=$name"
    }
}

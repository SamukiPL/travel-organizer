package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import me.samuki.stageadd.presentation.StageAddScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

internal class StageAdd @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(idArgument) {
                type = NavType.StringType
                nullable = false
            }
        )

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        StageAddScreen(stageAddNavigation = navigation, goBackNavigation = navigation)
    }

    companion object {
        private const val stageAdd = "stageAdd"
        const val idArgument = "id"
        const val route = "$stageAdd?$idArgument={$idArgument}"

        fun createRoute(id: String) = "$stageAdd?$idArgument=$id"
    }
}

package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import me.samuki.addstage.presentation.AddStageScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

internal class AddStage @Inject constructor() : Destination {
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
        AddStageScreen(addStageNavigation = navigation)
    }

    companion object {
        private const val addStage = "addStage"
        const val idArgument = "id"
        const val route = "$addStage?$idArgument={$idArgument}"

        fun createRoute(id: String) = "$addStage?$idArgument=$id"
    }
}

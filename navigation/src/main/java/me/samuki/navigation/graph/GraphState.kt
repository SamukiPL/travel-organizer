package me.samuki.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import me.samuki.navigation.destinations.Dashboard
import me.samuki.navigation.destinations.Destination
import me.samuki.navigation.destinations.OnBoarding

@Composable
fun rememberGraphState(
    navController: NavHostController,
    destinations: Set<Destination>,
    wasOnBoardingSeen: Boolean
): GraphState {
    return remember(navController, destinations) {
        GraphState(navController, destinations, wasOnBoardingSeen)
    }
}

@Stable
class GraphState(
    val navController: NavHostController,
    val destinations: Set<Destination>,
    wasOnBoardingSeen: Boolean
) {
    val firstScreen = if (wasOnBoardingSeen) Dashboard.route else OnBoarding.route

    private val currentNativeDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    fun popBackStack() = navController.popBackStack()
}

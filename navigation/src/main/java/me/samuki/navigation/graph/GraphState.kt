package me.samuki.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import me.samuki.navigation.destinations.Destination

@Composable
fun rememberGraphState(
    navController: NavHostController,
    destinations: Set<Destination>
): GraphState {
    return remember(navController, destinations) {
        GraphState(navController, destinations)
    }
}

class GraphState(
    val navController: NavHostController,
    val destinations: Set<Destination>
) {
    private val currentNativeDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val title = mutableStateOf<String?>(null)

    val shouldShowBackButton: Boolean
        @Composable get() = navController.backQueue.size > 1
}

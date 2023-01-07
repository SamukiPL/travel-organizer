package me.samuki.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.samuki.navigation.AppNavigation

@Composable
fun GraphBuilder(graphState: GraphState, modifier: Modifier = Modifier) {
    val navController = graphState.navController
    val appNavigation = AppNavigation(navController)

    NavHost(
        navController = navController,
        startDestination = graphState.firstScreen,
        modifier = modifier
    ) {
        graphState.destinations.forEach { destination ->
            composable(destination.routeName, arguments = destination.arguments) {
                destination.BuildDestination(
                    navigation = appNavigation
                )
            }
        }
    }
}

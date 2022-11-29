package me.samuki.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.samuki.navigation.AppNavigation
import me.samuki.navigation.destinations.OnBoarding

@Composable
fun GraphBuilder(graphState: GraphState) {
    val navController = graphState.navController
    val appNavigation = AppNavigation(navController)

    NavHost(navController = navController, startDestination = OnBoarding.route) {
        graphState.destinations.forEach { destination ->
            composable(destination.routeName, arguments = destination.arguments) {
                destination.BuildDestination(
                    navigation = appNavigation,
                    graphState.title::value::set
                )
            }
        }
    }
}

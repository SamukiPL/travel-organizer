package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import me.samuki.dashboard.presentation.DashboardScreen
import me.samuki.navigation.AppNavigation
import javax.inject.Inject

internal class Dashboard @Inject constructor() : Destination {
    override val routeName: String
        get() = route
    override val arguments: List<NamedNavArgument>
        get() = emptyList()

    @Composable
    override fun BuildDestination(navigation: AppNavigation) {
        DashboardScreen(navigation)
    }

    companion object {
        const val route = "dashboard"
    }
}

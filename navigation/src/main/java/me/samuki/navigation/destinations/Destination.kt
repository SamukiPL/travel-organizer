package me.samuki.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import me.samuki.navigation.AppNavigation

interface Destination {
    val routeName: String
    val arguments: List<NamedNavArgument>

    @Composable
    fun BuildDestination(navigation: AppNavigation)
}

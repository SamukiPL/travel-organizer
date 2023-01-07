package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.core.presentation.navigation.GoBackNavigation

internal class ProvidedGoBackNavigation(
    private val navController: NavController
) : GoBackNavigation {
    override fun goBack() {
        navController.popBackStack()
    }
}

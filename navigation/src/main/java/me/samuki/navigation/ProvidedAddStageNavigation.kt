package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.addstage.presentation.AddStageNavigation
import me.samuki.navigation.destinations.AddStage
import me.samuki.navigation.ext.getString

class ProvidedAddStageNavigation(private val navController: NavController) : AddStageNavigation {
    override fun getJourneyIdArgument(): String =
        requireNotNull(navController.getString(AddStage.idArgument) ?: "TODO")
}

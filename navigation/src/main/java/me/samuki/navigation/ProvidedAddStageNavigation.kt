package me.samuki.navigation

import androidx.navigation.NavController
import me.samuki.stageadd.presentation.StageAddNavigation
import me.samuki.navigation.destinations.StageAdd
import me.samuki.navigation.ext.getString

class ProvidedStageAddNavigation(private val navController: NavController) : StageAddNavigation {
    override fun getJourneyIdArgument(): String =
        requireNotNull(navController.getString(StageAdd.idArgument) ?: "TODO")
}

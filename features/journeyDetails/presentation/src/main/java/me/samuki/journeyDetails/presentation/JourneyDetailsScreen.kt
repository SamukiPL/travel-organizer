package me.samuki.journeyDetails.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun JourneyDetailsScreen(
    journeyDetailsNavigation: JourneyDetailsNavigation
) {
    val viewModel: JourneyDetailsViewModel = hiltViewModel()
    Text(text = journeyDetailsNavigation.getJourneyDetailsIdArgument())
}

@Composable
private fun JourneyDetailsContent() {

}

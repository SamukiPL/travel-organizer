package me.samuki.journeyDetails.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.samuki.journeyDetails.presentation.states.JourneyDetailsEmpty
import me.samuki.journeyDetails.presentation.states.JourneyDetailsLoading
import me.samuki.journeyDetails.presentation.states.JourneyDetailsState

@Composable
fun JourneyDetailsScreen(
    journeyDetailsNavigation: JourneyDetailsNavigation,
    changeTitle: (String) -> Unit,
    viewModel: JourneyDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.initDetails(journeyDetailsNavigation.getJourneyDetailsIdArgument())
    }

    val state = viewModel.viewState
    JourneyDetailsContent(state, journeyDetailsNavigation::goToAddNewStage)
    changeTitle(stringResource(id = R.string.journey_details_title))
}

@Composable
private fun JourneyDetailsContent(
    state: JourneyDetailsViewModel.ViewState,
    addStage: () -> Unit
) {
    Crossfade(targetState = state.state) {
        when (it) {
            JourneyDetailsState.Loading -> JourneyDetailsLoading()
            is JourneyDetailsState.Empty -> {
                JourneyDetailsEmpty(addStage, modifier = Modifier.padding(16.dp))
            }
            JourneyDetailsState.Content -> TODO()
            JourneyDetailsState.Error -> TODO()
        }
    }
}

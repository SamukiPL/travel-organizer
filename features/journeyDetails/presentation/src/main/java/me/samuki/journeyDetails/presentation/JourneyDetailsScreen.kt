package me.samuki.journeyDetails.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import me.samuki.journeyDetails.presentation.states.JourneyDetailsEmpty
import me.samuki.journeyDetails.presentation.states.JourneyDetailsLoading
import me.samuki.journeyDetails.presentation.states.JourneyDetailsState

@Composable
fun JourneyDetailsScreen(
    journeyDetailsNavigation: JourneyDetailsNavigation
): String {
    val viewModel: JourneyDetailsViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.initDetails(journeyDetailsNavigation.getJourneyDetailsIdArgument())
    }

    val state by remember {
        viewModel.viewState
    }
    JourneyDetailsContent(state, viewModel::click)

    return stringResource(id = R.string.journey_details_title)
}

@Composable
private fun JourneyDetailsContent(
    state: JourneyDetailsState,
    changeState: () -> Unit
) {
    Crossfade(targetState = state) {
        when (state) {
            JourneyDetailsState.Loading -> JourneyDetailsLoading(modifier = Modifier.clickable { changeState() })
            JourneyDetailsState.Empty -> JourneyDetailsEmpty()
            JourneyDetailsState.Content -> TODO()
            JourneyDetailsState.Error -> TODO()
        }
    }
}

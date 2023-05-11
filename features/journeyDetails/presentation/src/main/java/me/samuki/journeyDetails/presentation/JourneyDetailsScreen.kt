package me.samuki.journeyDetails.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.samuki.core.presentation.navigation.GoBackNavigation
import me.samuki.core.ui.TravelTopBar
import me.samuki.journeyDetails.presentation.states.JourneyDetailsEmpty
import me.samuki.journeyDetails.presentation.states.JourneyDetailsList
import me.samuki.journeyDetails.presentation.states.JourneyDetailsLoading
import me.samuki.journeyDetails.presentation.states.JourneyDetailsState

@Composable
fun JourneyDetailsScreen(
    journeyDetailsNavigation: JourneyDetailsNavigation,
    goBackNavigation: GoBackNavigation
) {
    val viewModel: JourneyDetailsViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.initDetails(journeyDetailsNavigation.getJourneyDetailsIdArgument())
    }

    viewModel.viewEvent {
        when (it) {
            is JourneyDetailsViewModel.ViewEvent.GoToAddNewStage -> journeyDetailsNavigation.goToAddNewStage(
                it.journeyId
            )
        }
    }

    val state = viewModel.viewState
    JourneyDetailsContent(
        state.journeyTitle,
        state.detailsState,
        viewModel::goToAddNewStage,
        goBackNavigation::goBack
    )
}

@Composable
private fun JourneyDetailsContent(
    title: String?,
    state: JourneyDetailsState,
    stageAdd: () -> Unit,
    goBack: () -> Unit
) {
    Column {
        TravelTopBar(
            title = title ?: stringResource(id = R.string.journey_details_title),
            showBackButton = true,
            backButtonAction = goBack
        )
        Crossfade(targetState = state) {
            when (it) {
                JourneyDetailsState.Loading -> JourneyDetailsLoading()
                JourneyDetailsState.Empty -> {
                    JourneyDetailsEmpty(stageAdd, modifier = Modifier.padding(16.dp))
                }

                is JourneyDetailsState.Content -> JourneyDetailsList(it.items)
                JourneyDetailsState.Error -> TODO()
            }
        }
    }
}

@Preview
@Composable
private fun JourneyDetailsContentPreview() {
    JourneyDetailsContent(
        "Test",
        JourneyDetailsState.Empty,
        stageAdd = { /*TODO*/ }) {

    }
}


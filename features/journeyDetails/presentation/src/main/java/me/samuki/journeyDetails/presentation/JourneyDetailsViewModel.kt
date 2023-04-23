package me.samuki.journeyDetails.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.samuki.composableevent.getValue
import me.samuki.composableevent.mutableEventOf
import me.samuki.core.domain.model.Stage
import me.samuki.core.presentation.items.toItem
import me.samuki.journeyDetails.domain.ObserveJourneyDetails
import me.samuki.journeyDetails.domain.SyncJourneyDetails
import me.samuki.journeyDetails.presentation.states.JourneyDetailsState
import me.samuki.travel.common.util.onEachResultSuccess
import javax.inject.Inject

@HiltViewModel
internal class JourneyDetailsViewModel @Inject constructor(
    private val observeJourneyDetails: ObserveJourneyDetails,
    private val syncJourneyDetails: SyncJourneyDetails
) : ViewModel() {

    var viewState by mutableStateOf(ViewState())
        private set

    private val _viewEvent = mutableEventOf<ViewEvent>()
    val viewEvent by _viewEvent

    fun initDetails(journeyId: String) {
        viewModelScope.launch {
            syncJourneyDetails(journeyId)

            observeJourneyDetails(journeyId)
                .onEachResultSuccess {
                    viewState = viewState.copy(
                        journeyId = journeyId,
                        journeyTitle = it.journey.name,
                        detailsState = it.stages.getDetailsState()
                    )
                }
                .collect()
        }
    }

    private fun List<Stage>.getDetailsState() = if (isEmpty()) {
        JourneyDetailsState.Empty
    } else {
        JourneyDetailsState.Content(map(Stage::toItem))
    }

    fun goToAddNewStage() {
        viewState.journeyId?.let {
            _viewEvent.sendEvent(ViewEvent.GoToAddNewStage(it))
        }
    }

    data class ViewState(
        val journeyId: String? = null,
        val journeyTitle: String? = null,
        val detailsState: JourneyDetailsState = JourneyDetailsState.Loading
    )

    sealed interface ViewEvent {
        data class GoToAddNewStage(val journeyId: String) : ViewEvent
    }
}

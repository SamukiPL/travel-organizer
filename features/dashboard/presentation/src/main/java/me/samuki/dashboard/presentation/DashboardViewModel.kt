package me.samuki.dashboard.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import me.samuki.composableevent.Event
import me.samuki.composableevent.mutableEventOf
import me.samuki.core.domain.model.Journey
import me.samuki.core.presentation.items.JourneyItem
import me.samuki.core.presentation.items.toItem
import me.samuki.dashboard.domain.ObserveJourneys
import me.samuki.dashboard.domain.SyncJourneys
import me.samuki.travel.common.util.onEachResultSuccess
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(
    private val observeJourneys: ObserveJourneys,
    private val syncJourneys: SyncJourneys
) : ViewModel() {
    var viewState by mutableStateOf(ViewData())

    private val _event = mutableEventOf<ViewEvent>()
    val event: Event<ViewEvent> = _event

    fun loadData() {
        observeJourneys()
            .mapLatest { result ->
                result.map {
                    it.map(Journey::toItem)
                }
            }
            .onEachResultSuccess {
                viewState = viewState.copy(
                    journeys = it
                )
            }
            .launchIn(viewModelScope)

        viewModelScope.launch(context = errorHandler()) {
            syncJourneys()
        }
    }

    private fun errorHandler() = CoroutineExceptionHandler { _, throwable ->
        viewState = viewState.copy(
            localOnly = true
        )
    }

    data class ViewData(
        val journeys: List<JourneyItem> = emptyList(),
        val localOnly: Boolean = false
    )

    sealed interface ViewEvent {
    }
}

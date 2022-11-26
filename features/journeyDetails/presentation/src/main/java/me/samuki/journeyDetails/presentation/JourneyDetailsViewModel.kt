package me.samuki.journeyDetails.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.samuki.composableevent.getValue
import me.samuki.composableevent.mutableEventOf
import me.samuki.journeyDetails.presentation.states.JourneyDetailsState
import javax.inject.Inject

@HiltViewModel
class JourneyDetailsViewModel @Inject constructor() : ViewModel() {

    var viewState by mutableStateOf(ViewState())
        private set

    private val _viewEvent = mutableEventOf<ViewEvent>()
    val viewEvent by _viewEvent

    fun initDetails(id: String) {
        viewModelScope.launch {
            delay(5000)
            viewState = viewState.copy(
                state = JourneyDetailsState.Empty
            )
        }
    }

    fun addStage() {

    }

    data class ViewState(
        val state: JourneyDetailsState = JourneyDetailsState.Loading
    )

    sealed interface ViewEvent {

    }
}

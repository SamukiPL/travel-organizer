package me.samuki.journeyDetails.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.samuki.journeyDetails.presentation.states.JourneyDetailsState
import javax.inject.Inject

@HiltViewModel
internal class JourneyDetailsViewModel @Inject constructor() : ViewModel() {

    private val _viewState = mutableStateOf<JourneyDetailsState>(JourneyDetailsState.Loading)
    val viewState: State<JourneyDetailsState> = _viewState

    fun initDetails(id: String) {
    }

    fun click() {
        _viewState.value = JourneyDetailsState.Empty
    }

}

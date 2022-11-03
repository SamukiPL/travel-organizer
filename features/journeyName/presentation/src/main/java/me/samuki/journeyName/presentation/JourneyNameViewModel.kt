package me.samuki.journeyName.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.samuki.composableevent.Event
import me.samuki.composableevent.mutableEventOf
import me.samuki.journeyName.domain.CreateNewJourney
import me.samuki.journeyName.domain.EditJourneyName
import javax.inject.Inject

@HiltViewModel
internal class JourneyNameViewModel @Inject constructor(
    private val createNewJourney: CreateNewJourney,
    private val editJourneyName: EditJourneyName
) : ViewModel() {

    private val _viewState = mutableStateOf(ViewState())
    val viewState: State<ViewState> = _viewState

    private val _successEvent = mutableEventOf<String>()
    val successEvent: Event<String> = _successEvent

    fun initState(id: String?, name: String?) {
        _viewState.value = _viewState.value.copy(
            id = id,
            type = id?.let { JourneyNameType.Change } ?: JourneyNameType.New,
            name = name.orEmpty()
        )
    }

    fun changeName(name: String) {
        _viewState.value = _viewState.value.copy(
            name = name
        )
    }

    fun takeAction() {
        val currentState = viewState.value
        if (currentState.name.isEmpty()) return

        if (currentState.type == JourneyNameType.New) {
            createNew(currentState.name)
        } else {
            editName(requireNotNull(currentState.id), currentState.name)
        }
    }

    private fun createNew(name: String) {
        viewModelScope.launch {
            createNewJourney(name).onSuccess {
                _successEvent.sendEvent(it)
            }.onFailure {

            }
        }
    }

    private fun editName(id: String, name: String) {
        viewModelScope.launch {
            editJourneyName(id, name).onSuccess {
                _successEvent.sendEvent(it)
            }.onFailure {

            }
        }
    }

    data class ViewState(
        val id: String? = null,
        val type: JourneyNameType = JourneyNameType.New,
        val name: String = ""
    )
}

package me.samuki.journeyName.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.samuki.composableevent.Event
import me.samuki.composableevent.mutableEventOf
import me.samuki.journeyName.domain.CreateOrUpdateName
import javax.inject.Inject

@HiltViewModel
internal class JourneyNameViewModel @Inject constructor(
    private val createNewJourney: CreateOrUpdateName,
) : ViewModel() {

    var viewState by mutableStateOf(ViewState())
        private set

    private val _successEvent = mutableEventOf<String>()
    val successEvent: Event<String> = _successEvent

    fun initState(id: String?, name: String?) {
        viewState = viewState.copy(
            id = id,
            type = id?.let { JourneyNameType.Change } ?: JourneyNameType.New,
            name = name.orEmpty()
        )
    }

    fun changeName(name: String) {
        viewState = viewState.copy(
            name = name
        )
    }

    fun takeAction() {
        if (viewState.name.isEmpty()) return

        viewState = viewState.copy(
            loadingVisible = true
        )
        viewModelScope.launch {
            createNewJourney(viewState.id, viewState.name).onSuccess {
                _successEvent.sendEvent(it)
            }.onFailure {
                viewState = viewState.copy(
                    loadingVisible = false,
                    errorVisible = true
                )
            }
        }
    }

    data class ViewState(
        val id: String? = null,
        val type: JourneyNameType = JourneyNameType.New,
        val name: String = "",
        val loadingVisible: Boolean = false,
        val errorVisible: Boolean = false
    )
}

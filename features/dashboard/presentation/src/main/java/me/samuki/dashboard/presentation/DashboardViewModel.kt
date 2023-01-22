package me.samuki.dashboard.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.samuki.composableevent.Event
import me.samuki.composableevent.mutableEventOf
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(
) : ViewModel() {
    private val _event = mutableEventOf<ViewEvent>()
    val event: Event<ViewEvent> = _event

    fun checkFirstTimeOpen() {
    }

    sealed interface ViewEvent {
    }
}

package me.samuki.onboarding

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.samuki.composableevent.Event
import me.samuki.composableevent.mutableEventOf
import me.samuki.core.settings.WasOnBoardingSeen
import javax.inject.Inject

@HiltViewModel
internal class OnBoardingViewModel @Inject constructor(
    private val wasOnBoardingSeen: WasOnBoardingSeen
) : ViewModel() {
    private val _viewEvent = mutableEventOf<ViewEvent>()
    val viewEvent: Event<ViewEvent> = _viewEvent

    fun endOnBoarding() {
        wasOnBoardingSeen.value = true
        _viewEvent.sendEvent(ViewEvent.EndOnBoarding)
    }

    sealed interface ViewEvent {
        object EndOnBoarding: ViewEvent
    }
}

package me.samuki.addstage.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.samuki.addstage.domain.CreateStage
import me.samuki.addstage.domain.NewStage
import me.samuki.addstage.presentation.urlPreview.UrlPreviewState
import me.samuki.composableevent.Event
import me.samuki.composableevent.mutableEventOf
import me.samuki.core.domain.urlScrapping.GetUrlMetadata
import me.samuki.core.model.Id
import me.samuki.core.model.StageType
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
internal class AddStageViewModel @Inject constructor(
    private val getUrlMetadata: GetUrlMetadata,
    private val createStage: CreateStage
) : ViewModel() {

    var viewState by mutableStateOf(ViewState())
        private set

    private val _viewEvent = mutableEventOf<ViewEvent>()
    val viewEvent: Event<ViewEvent> = _viewEvent

    fun initState(journeyIdArgument: String) {
        viewState = viewState.copy(journeyId = journeyIdArgument)
    }

    fun changeTitle(title: String) {
        viewState = viewState.copy(
            title = title,
            typeVisible = viewState.typeVisible || title.length >= 3
        )
    }

    fun changeType(type: StageType) {
        viewState = viewState.copy(
            type = type
        )
    }

    private var urlChangeJob: Job? = null
    fun changeUrl(url: String) {
        viewState = viewState.copy(
            url = url
        )
        urlChangeJob?.cancel()
        urlChangeJob = viewModelScope.launch {
            viewState = viewState.copy(
                urlPreviewState = UrlPreviewState.Loading
            )
            delay(1.seconds)
            getUrlMetadata(url)
                .onSuccess { metadata ->
                    viewState = viewState.copy(
                        urlPreviewState = (metadata.image)?.let {
                            UrlPreviewState.Downloaded(urlImage = it, urlName = metadata.siteName)
                        } ?: UrlPreviewState.Empty
                    )
                }
                .onFailure {
                    viewState = viewState.copy(urlPreviewState = UrlPreviewState.Error)
                }
        }
    }

    fun createStage() {
        viewModelScope.launch {
            val preview: UrlPreviewState.Downloaded? =
                viewState.urlPreviewState as? UrlPreviewState.Downloaded
            createStage(
                NewStage(
                    journeyId = Id(viewState.journeyId!!),
                    name = viewState.title,
                    type = viewState.type!!,
                    url = viewState.url,
                    urlName = preview?.urlName,
                    urlImage = preview?.urlImage
                )
            ).onSuccess {
                _viewEvent.sendEvent(ViewEvent.StageCreated(it.toString()))
            }.onFailure {
                viewState = viewState.copy(showError = true)
            }
        }
    }

    data class ViewState(
        val journeyId: String? = null,
        val title: String = "",
        val type: StageType? = null,
        val url: String = "",
        val typeVisible: Boolean = false,
        val urlPreviewState: UrlPreviewState = UrlPreviewState.Hidden,
        val showError: Boolean = false
    ) {
        val urlVisible get() = type != null
        val createButtonVisible get() = urlPreviewState !is UrlPreviewState.Hidden && urlPreviewState !is UrlPreviewState.Loading
    }

    sealed interface ViewEvent {
        data class StageCreated(
            val stageId: String
        ) : ViewEvent
    }
}

package me.samuki.addstage.presentation.urlPreview

internal sealed interface UrlPreviewState {
     object Hidden : UrlPreviewState
     object Loading : UrlPreviewState
     object Error : UrlPreviewState
     object Empty : UrlPreviewState

     data class Downloaded(
         val urlImage: String,
         val urlName: String?
    ) : UrlPreviewState
}

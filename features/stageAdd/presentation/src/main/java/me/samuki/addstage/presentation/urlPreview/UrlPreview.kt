package me.samuki.stageadd.presentation.urlPreview

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import me.samuki.stageadd.presentation.R
import me.samuki.core.ui.design.checkableBackground
import me.samuki.core.ui.design.travelBorder

@Composable
internal fun UrlPreview(
    previewState: UrlPreviewState,
    modifier: Modifier = Modifier,
) {
    Crossfade(targetState = previewState, modifier = modifier) {
        when (it) {
            is UrlPreviewState.Downloaded -> Downloaded(it.urlImage, it.urlName)
            UrlPreviewState.Error -> Error()
            UrlPreviewState.Hidden -> {}
            UrlPreviewState.Loading -> Loading()
            UrlPreviewState.Empty -> Empty()
        }
    }
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    StageUrlBox(isChecked = false, modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(8.dp)
                .size(32.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun Error(modifier: Modifier = Modifier) {
    StageUrlBox(isChecked = false, modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.Warning, contentDescription = null)
            Text(text = stringResource(R.string.url_preview_error))
        }
    }
}

@Composable
private fun Downloaded(imageUrl: String, urlName: String?, modifier: Modifier = Modifier) {
    StageUrlBox(isChecked = true, modifier = modifier) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = urlName.orEmpty(),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(
                    Color.Gray.copy(alpha = 0.5F)
                )
                .padding(4.dp),
            color = Color.White,
            fontSize = 10.sp
        )
    }
}

@Composable
private fun Empty(modifier: Modifier = Modifier) {
    StageUrlBox(isChecked = false, modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.Warning, contentDescription = null)
            Text(text = stringResource(R.string.url_preview_empty))
        }
    }
}

@Composable
private fun StageUrlBox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.75F)
            .aspectRatio(1.75F)
            .padding(8.dp)
            .travelBorder()
            .clip(MaterialTheme.shapes.medium)
            .background(isChecked.checkableBackground())
    ) {
        content()
    }
}

@Preview
@Composable
private fun UrlPreviewPreview() {
    Column(
        modifier = Modifier.width(100.dp)
    ) {
        UrlPreview(previewState = UrlPreviewState.Hidden)
        UrlPreview(previewState = UrlPreviewState.Loading)
        UrlPreview(previewState = UrlPreviewState.Error)
        UrlPreview(previewState = UrlPreviewState.Empty)
        UrlPreview(previewState = UrlPreviewState.Downloaded(urlImage = "", urlName = "My url"))
    }
}

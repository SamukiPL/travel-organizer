package me.samuki.core.ui

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TravelTopBar(
    @StringRes title: String,
    modifier: Modifier = Modifier,
    shouldShowBackButton: Boolean,
    backButtonAction: () -> Unit
) {
    val startPadding = if (shouldShowBackButton) 4.dp else 16.dp
    AnimatedVisibility(
        visible = title.isNotEmpty(),
        modifier = modifier.padding(start = startPadding, top = 8.dp)
    ) {
        TopBarRow(
            title = title,
            shouldShowBackButton = shouldShowBackButton,
            backButtonAction = backButtonAction
        )
    }
}

@Composable
private fun TopBarRow(
    title: String,
    modifier: Modifier = Modifier,
    shouldShowBackButton: Boolean,
    backButtonAction: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (shouldShowBackButton) {
            IconButton(onClick = { backButtonAction.invoke() }) {
                Icon(
                    painterResource(id = R.drawable.ic_back_arrow),
                    null,
                )
            }
        }
        AnimatedText(title = title)
    }
}

@Composable
private fun AnimatedText(title: String) {
    Crossfade(targetState = title) {
        Text(
            text = it.uppercase(),
            style = MaterialTheme.typography.h5,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

package me.samuki.core.ui

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
    title: String,
    showBackButton: Boolean,
    modifier: Modifier = Modifier,
    backButtonAction: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = if (showBackButton) 4.dp else 16.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBackButton) {
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

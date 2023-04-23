package me.samuki.core.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingButton(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    action: () -> Unit
) {
    Button(
        onClick = action,
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        enabled = isLoading.not()
    ) {
        Crossfade(targetState = isLoading) {
            when (it) {
                true -> AnimatedLoading()
                false -> ButtonContent(text = text)
            }
        }
    }
}

@Composable
private fun AnimatedLoading() {
    val onPrimaryColor = MaterialTheme.colors.onPrimary
    val infiniteTransition = rememberInfiniteTransition()
    val rotation1 by infiniteTransition.animateFloat(
        initialValue = 0F, targetValue = 360F, animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1500
                0F at 200
                360F at 1300
            }, repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(
        modifier = Modifier
            .fillMaxWidth(0.5F)
            .height(19.dp)
    ) {
        rotate(rotation1) {
            drawRoundRect(
                color = onPrimaryColor,
                size = size.copy(width = size.height),
                cornerRadius = CornerRadius(8F, 8F),
                topLeft = Offset((size.width / 2) - (size.height / 2), 0F)
            )
        }
    }
}

@Composable
private fun ButtonContent(text: String) {
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.button,
        maxLines = 1
    )
}

@Preview
@Composable
private fun ButtonPreview() {
    LoadingButton(text = "Add", isLoading = false) {
    }
}

@Preview
@Composable
private fun LoadingButtonPreview() {
    LoadingButton(text = "Add", isLoading = true) {
    }
}

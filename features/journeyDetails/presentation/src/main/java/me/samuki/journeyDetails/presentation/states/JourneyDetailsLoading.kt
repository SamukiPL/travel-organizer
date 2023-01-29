package me.samuki.journeyDetails.presentation.states

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import java.lang.Float.min

@Composable
internal fun JourneyDetailsLoading(modifier: Modifier = Modifier) {
    val buttonSize = 64
    val buttonPadding = 16
    val itemHeight = 175
    val itemPadding = 16
    val heightDp = LocalConfiguration.current.screenHeightDp - buttonSize - (buttonPadding * 2)

    val infiniteTransition = rememberInfiniteTransition()
    val animatedColor by infiniteTransition.animateColor(
        initialValue = MaterialTheme.colors.primary.copy(alpha = 0.2F),
        targetValue = MaterialTheme.colors.primary.copy(alpha = 0.7F),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1500
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    val size = remember {
        Animatable(0F)
    }
    LaunchedEffect(size) {
        size.animateTo(
            4F,
            animationSpec = keyframes {
                durationMillis = 4000
                0F at 2000
                1F at 2500 with FastOutSlowInEasing
                2F at 3000 with FastOutSlowInEasing
                3F at 3500 with FastOutSlowInEasing
                4F at 4000 with FastOutSlowInEasing
            },
            initialVelocity = 1F
        )
    }
    val imageSize = min(size.value, 1F)
    val titleSize = min(size.value - 1F, 1F)
    val descriptionSize = min(size.value - 2F, 1F)
    val secondDescriptionSize = min(size.value - 3F, 1F)

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(heightDp / (itemHeight + itemPadding * 2)) {
            SkeletonItem(
                animatedColor,
                imageSize,
                titleSize,
                descriptionSize,
                secondDescriptionSize,
                modifier = Modifier
                    .padding(itemPadding.dp)
                    .height(itemHeight.dp)
                    .border(
                        BorderStroke(
                            width = 3.dp,
                            animatedColor
                        ),
                        shape = MaterialTheme.shapes.medium
                    )
            )
        }
        SkeletonAddButton(
            infiniteTransition,
            animatedColor,
            modifier = Modifier
                .padding(buttonPadding.dp)
                .size(buttonSize.dp)
                .border(
                    BorderStroke(
                        width = 3.dp,
                        animatedColor
                    ),
                    shape = MaterialTheme.shapes.medium
                )
        )
    }
}

@Composable
private fun SkeletonItem(
    animatedColor: Color,
    imageSize: Float,
    titleSize: Float,
    descriptionSize: Float,
    secondDescriptionSize: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.75F * imageSize)
                    .fillMaxWidth(0.35F * imageSize)
                    .background(animatedColor)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .height((24 * titleSize).dp)
                        .background(animatedColor)
                )
                Box(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(secondDescriptionSize)
                        .height((36.dp * secondDescriptionSize))
                        .background(animatedColor)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(descriptionSize)
                        .fillMaxHeight()
                        .background(animatedColor)
                )
            }
        }
    }
}

@Composable
private fun SkeletonAddButton(
    infiniteTransition: InfiniteTransition,
    animatedColor: Color,
    modifier: Modifier = Modifier
) {
    val rotation1 by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1500
                0F at 100
                360F at 1300
            },
            repeatMode = RepeatMode.Reverse
        )
    )
    val rotation2 by infiniteTransition.animateFloat(
        initialValue = -360F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 3000
                -360F at 100
                360F at 2700
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
                .fillMaxWidth()
                .fillMaxHeight(0.5F)
        ) {
            drawArc(
                color = animatedColor,
                startAngle = rotation1,
                sweepAngle = rotation2,
                useCenter = true,
                style = Stroke(
                    width = 3.dp.toPx()
                )
            )
        }
    }
}

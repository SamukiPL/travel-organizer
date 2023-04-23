package me.samuki.core.ui.design

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Boolean.checkableBackground() = if (this) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(alpha = 0.3F)

@Composable
fun Boolean.onCheckableBackground() = if (this) Color.White else MaterialTheme.colors.onBackground

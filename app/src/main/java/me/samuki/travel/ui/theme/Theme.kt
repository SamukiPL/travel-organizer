package me.samuki.travel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Teal700,
    background = darkBackground,
    surface = Purple200,
    onPrimary = Color.White,
    onSecondary = Color.DarkGray,
    onBackground = Color.White,
    onSurface = Purple200,
    onError = Color.Red
)

private val LightColorPalette = lightColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Teal700,
    background = lightBackground,
    surface = Purple200,
    onPrimary = Color.DarkGray,
    onSecondary = Color.White,
    onBackground = Color.DarkGray,
    onSurface = Purple200,
    onError = Color.Red
)

@Composable
fun TravelTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

package me.samuki.core.ui.input

import android.graphics.drawable.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SingleLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String? = null,
    placeholderText: String? = null,
    enabled: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    FullTravelTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        labelText = labelText,
        placeholderText = placeholderText,
        enabled = enabled,
        singleLine = true,
        maxLines = 1,
        trailingIcon = trailingIcon
    )
}

package me.samuki.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.samuki.core.ui.input.FullTravelTextField

@Composable
fun TravelTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String? = null,
    placeholderText: String? = null,
    enabled: Boolean = true
) {
    FullTravelTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        labelText = labelText,
        placeholderText = placeholderText,
        modifier = modifier
    )
}


@Preview
@Composable
fun TravelTextFieldPreview() {
    TravelTextField(
        "Awesome Journey",
        onValueChange = {},
        labelText = "Journey Name",
        enabled = false
    )
}

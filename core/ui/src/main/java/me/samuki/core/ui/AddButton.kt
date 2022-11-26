package me.samuki.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Icon(
        Icons.Rounded.Add,
        contentDescription = null,
        modifier = modifier
            .size(48.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(
                MaterialTheme.colors.primary,
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.primaryVariant.copy(alpha = 0.3F),
                shape = MaterialTheme.shapes.medium
            )
            .clickable(onClick = onClick),
        tint = MaterialTheme.colors.primaryVariant
    )

}

@Preview
@Composable
private fun AddButtonPreview() {
    Surface {
        AddButton(modifier = Modifier.padding(8.dp), onClick = {})
    }
}

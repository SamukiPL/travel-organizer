package me.samuki.dashboard.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.samuki.core.presentation.items.JourneyItem

@Composable
fun JourneyView(
    item: JourneyItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(42.dp)
            .background(MaterialTheme.colors.primary.copy(alpha = 0.1F))
    ) {
        Text(text = item.name)
    }
}

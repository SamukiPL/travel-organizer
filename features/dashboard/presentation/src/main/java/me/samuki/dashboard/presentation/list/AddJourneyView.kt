package me.samuki.dashboard.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.samuki.core.ui.AddButton

@Composable
fun AddJourneyView(
    modifier: Modifier = Modifier,
    addJourney: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        AddButton(
            onClick = addJourney
        )
    }
}

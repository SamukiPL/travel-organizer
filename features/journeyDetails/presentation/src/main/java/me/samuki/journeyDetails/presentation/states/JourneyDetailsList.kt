package me.samuki.journeyDetails.presentation.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.samuki.core.presentation.items.StageItem

@Composable
fun JourneyDetailsList(items: List<StageItem>) {
    Column {
        items.forEach {
            Text(text = it.name)
            Text(text = it.id.toString())
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

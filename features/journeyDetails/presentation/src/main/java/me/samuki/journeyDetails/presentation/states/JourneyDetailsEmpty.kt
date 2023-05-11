package me.samuki.journeyDetails.presentation.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.samuki.core.ui.AddButton
import me.samuki.journeyDetails.presentation.R

@Composable
internal fun JourneyDetailsEmpty(stageAdd: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stringResource(id = R.string.empty_journey_title),
            style = MaterialTheme.typography.h6.copy(textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        Text(
            stringResource(id = R.string.empty_journey_description),
            style = MaterialTheme.typography.subtitle2.copy(textAlign = TextAlign.Justify),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        AddButton(onClick = stageAdd)
    }
}

@Preview
@Composable
private fun EmptyPreview() {
    Surface {
        JourneyDetailsEmpty({})
    }
}

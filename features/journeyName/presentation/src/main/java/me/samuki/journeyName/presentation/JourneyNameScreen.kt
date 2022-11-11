package me.samuki.journeyName.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun JourneyNameScreen(navigation: JourneyNameNavigation): String {
    val viewModel: JourneyNameViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.initState(
            navigation.getJourneyNameIdArgument(),
            navigation.getJourneyNameNameArgument()
        )
    }

    viewModel.successEvent {
        navigation.goToDetails(it)
    }

    val state by remember {
        viewModel.viewState
    }
    JourneyNameContent(
        state.type,
        state.name,
        viewModel::changeName,
        viewModel::takeAction
    )

    return stringResource(id = state.type.title)
}

@Composable
private fun JourneyNameContent(
    type: JourneyNameType,
    text: String,
    textChange: (String) -> Unit,
    action: () -> Unit
) {
    Box(
        Modifier.fillMaxSize(),
    ) {
        DescriptionWithTextField(
            type = type,
            text = text,
            textChange = textChange,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        ActionButton(
            type = type,
            action = action,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun DescriptionWithTextField(
    type: JourneyNameType,
    text: String,
    textChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = type.description),
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            style = MaterialTheme.typography.subtitle2
        )
        OutlinedTextField(
            value = text,
            onValueChange = textChange,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.3F)
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
private fun ActionButton(
    type: JourneyNameType,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = action,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = stringResource(id = type.button).uppercase(),
            style = MaterialTheme.typography.button
        )
    }
}

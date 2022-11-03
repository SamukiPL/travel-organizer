package me.samuki.journeyName.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun JourneyNameScreen(navigation: JourneyNameNavigation) {
    val viewModel: JourneyNameViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.initState(navigation.getJourneyNameIdArgument(), navigation.getJourneyNameNameArgument())
    }

    viewModel.successEvent {
        navigation.goToDetails(it)
    }

    val state = viewModel.viewState.value
    JourneyNameContent(
        state.type,
        state.name,
        viewModel::changeName,
        viewModel::takeAction
    )
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
            text = stringResource(id = type.title).uppercase(),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp),
            style = MaterialTheme.typography.h4
        )
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

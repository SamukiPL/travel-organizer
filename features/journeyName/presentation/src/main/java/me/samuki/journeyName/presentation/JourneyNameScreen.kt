package me.samuki.journeyName.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.samuki.core.presentation.navigation.GoBackNavigation
import me.samuki.core.ui.LoadingButton
import me.samuki.core.ui.TravelTextField
import me.samuki.core.ui.TravelTopBar

@Composable
fun JourneyNameScreen(navigation: JourneyNameNavigation, goBackNavigation: GoBackNavigation) {
    val viewModel: JourneyNameViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.initState(
            navigation.getJourneyNameIdArgument(), navigation.getJourneyNameNameArgument()
        )
    }

    viewModel.successEvent {
        navigation.goToDetails(it)
    }

    JourneyNameContent(
        viewModel.viewState,
        viewModel::changeName,
        viewModel::takeAction,
        goBackNavigation::goBack
    )
}

@Composable
private fun JourneyNameContent(
    state: JourneyNameViewModel.ViewState,
    textChange: (String) -> Unit,
    action: () -> Unit,
    goBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TravelTopBar(
            stringResource(id = state.type.title),
            showBackButton = true,
            backButtonAction = goBack
        )
        JourneyNameBody(
            type = state.type,
            text = state.name,
            isLoading = state.loadingVisible,
            textChange = textChange,
            action = action,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun JourneyNameBody(
    type: JourneyNameType,
    text: String,
    isLoading: Boolean,
    textChange: (String) -> Unit,
    action: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier,
    ) {
        DescriptionWithTextField(
            type = type,
            text = text,
            enabled = isLoading.not(),
            textChange = textChange,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        LoadingButton(
            text = stringResource(id = type.button),
            isLoading = isLoading,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            action = action
        )
    }
}

@Composable
private fun DescriptionWithTextField(
    type: JourneyNameType,
    text: String,
    enabled: Boolean,
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
        TravelTextField(
            value = text,
            onValueChange = textChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            enabled = enabled,
            labelText = "Journey Name"
        )
    }
}

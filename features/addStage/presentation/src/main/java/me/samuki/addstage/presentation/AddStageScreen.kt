package me.samuki.addstage.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.samuki.addstage.presentation.urlPreview.UrlPreview
import me.samuki.addstage.presentation.urlPreview.UrlPreviewState
import me.samuki.core.model.StageType
import me.samuki.core.presentation.navigation.GoBackNavigation
import me.samuki.core.ui.LoadingButton
import me.samuki.core.ui.TravelTextField
import me.samuki.core.ui.TravelTopBar
import me.samuki.core.ui.input.SingleLineTextField

@Composable
fun AddStageScreen(addStageNavigation: AddStageNavigation, goBackNavigation: GoBackNavigation) {
    val viewModel: AddStageViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.initState(addStageNavigation.getJourneyIdArgument())
    }

    viewModel.viewEvent {
        when (it) {
            is AddStageViewModel.ViewEvent.StageCreated -> {
                goBackNavigation.goBack()
                //TODO: Maybe go to stage details
            }
        }
    }

    AddStageContent(
        viewModel.viewState,
        goBack = goBackNavigation::goBack,
        onTitleChange = viewModel::changeTitle,
        changeType = viewModel::changeType,
        onUrlChange = viewModel::changeUrl,
        createStage = viewModel::createStage,
    )
}

@Composable
private fun AddStageContent(
    viewState: AddStageViewModel.ViewState,
    goBack: () -> Unit,
    onTitleChange: (String) -> Unit,
    changeType: (StageType) -> Unit,
    onUrlChange: (String) -> Unit,
    createStage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val childrenModifier = Modifier
            .padding(horizontal = 16.dp)
        TravelTopBar(title = stringResource(R.string.add_stage_title), showBackButton = true) {
            goBack()
        }
        StageNameField(
            value = viewState.title,
            onValueChange = onTitleChange,
            modifier = childrenModifier.padding(vertical = 8.dp)
        )
        AnimatedVisibility(visible = viewState.typeVisible, modifier = childrenModifier) {
            StagePicker(
                currentType = viewState.type,
                changeType = changeType
            )
        }
        AnimatedVisibility(
            visible = viewState.urlVisible,
            modifier = childrenModifier.padding(vertical = 8.dp)
        ) {
            StageUrlField(
                value = viewState.url,
                onValueChange = onUrlChange,
                urlPreviewState = viewState.urlPreviewState
            )
        }
        Spacer(modifier = Modifier.weight(1F))
        AnimatedVisibility(
            visible = viewState.createButtonVisible,
            modifier = childrenModifier
                .padding(vertical = 16.dp)
        ) {
            LoadingButton(text = stringResource(R.string.add), isLoading = false) {
                createStage()
            }
        }
    }
}

@Composable
private fun StageNameField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TravelTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = true,
        labelText = stringResource(R.string.stage_name_label),
        modifier = modifier
            .fillMaxWidth()
    )
}


@Composable
private fun StageUrlField(
    value: String,
    urlPreviewState: UrlPreviewState,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = stringResource(R.string.stage_url_label))
        SingleLineTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            labelText = stringResource(R.string.stage_url_hint),
            placeholderText = stringResource(R.string.stage_url_placeholder),
            trailingIcon = {
                Icon(
                    Icons.Outlined.Close,
                    contentDescription = null
                )
            }
        )
        AnimatedVisibility(visible = true) {
            StageUrlPreview(urlPreviewState)
        }
    }
}

@Composable
private fun StageUrlPreview(
    previewState: UrlPreviewState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        UrlPreview(previewState = previewState)
    }
}


@Preview
@Composable
private fun AddStagePreview() {
    Scaffold {
        AddStageContent(
            viewState = AddStageViewModel.ViewState(
                title = "",
                type = StageType.Road,
                typeVisible = true,
                url = "Test"
            ),
            {},
            {},
            {},
            {},
            {},
            modifier = Modifier.padding(it)
        )
    }
}

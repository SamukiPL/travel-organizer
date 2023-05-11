package me.samuki.stageadd.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.samuki.core.model.StageType
import me.samuki.core.presentation.ext.nameResource
import me.samuki.core.ui.design.checkableBackground
import me.samuki.core.ui.design.onCheckableBackground
import me.samuki.core.ui.design.travelBorder

@Composable
fun StagePicker(
    currentType: StageType?,
    changeType: (StageType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.stage_type_label),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp)
                .travelBorder()
                .clip(MaterialTheme.shapes.medium)
        ) {
            StageType.values().forEach {
                StageTypeView(
                    stageType = it,
                    isChosen = currentType == it,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .clickable { changeType(it) }
                        .background(color = (currentType == it).checkableBackground())
                )
            }
        }
    }
}

@Composable
private fun StageTypeView(
    stageType: StageType,
    isChosen: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(
            text = stringResource(stageType.nameResource()),
            modifier = Modifier
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            color = isChosen.onCheckableBackground()
        )
    }
}

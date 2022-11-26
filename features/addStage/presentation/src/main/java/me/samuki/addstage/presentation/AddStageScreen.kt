package me.samuki.addstage.presentation

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AddStageScreen(addStageNavigation: AddStageNavigation) {
    Button(onClick = { addStageNavigation.returnToDetails() }) {
        Text(text = "Nawrat")
    }
}

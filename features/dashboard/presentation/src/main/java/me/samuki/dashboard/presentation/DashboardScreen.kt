package me.samuki.dashboard.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DashboardScreen(navigation: DashboardNavigation) {
    val viewModel: DashboardViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.checkFirstTimeOpen()
    }

    viewModel.event {
    }

    DashboardScreenContent()
}

@Composable
private fun DashboardScreenContent() {

}

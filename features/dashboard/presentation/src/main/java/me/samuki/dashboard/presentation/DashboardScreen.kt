package me.samuki.dashboard.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import me.samuki.core.presentation.items.JourneyItem
import me.samuki.dashboard.presentation.list.AddJourneyView
import me.samuki.dashboard.presentation.list.JourneyView

@Composable
fun DashboardScreen(navigation: DashboardNavigation) {
    val viewModel: DashboardViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    viewModel.event {
    }

    val state = viewModel.viewState
    DashboardScreenContent(
        items = state.journeys,
        goToDetails = navigation::goToJourney,
        addJourney = navigation::goToAddJourney
    )
}

@Composable
private fun DashboardScreenContent(
    items: List<JourneyItem>,
    goToDetails: (String) -> Unit,
    addJourney: () -> Unit
) {
    LazyColumn {
        items(items, key = { it.id }) {
            JourneyView(item = it, modifier = Modifier.clickable {
                goToDetails(it.id)
            })
        }
        item {
            AddJourneyView(addJourney = addJourney)
        }
    }
}

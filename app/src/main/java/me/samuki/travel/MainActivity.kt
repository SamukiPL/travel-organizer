package me.samuki.travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.samuki.core.ui.TravelTopBar
import me.samuki.navigation.destinations.Destination
import me.samuki.navigation.graph.GraphBuilder
import me.samuki.navigation.graph.rememberGraphState
import me.samuki.travel.ui.theme.TravelTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var destinations: Set<@JvmSuppressWildcards Destination>

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val graphState = rememberGraphState(
                navController = navController,
                destinations = destinations
            )

            TravelTheme {
                Scaffold(
                    topBar = {
                        TravelTopBar(
                            title = graphState.title.value.orEmpty(),
                            shouldShowBackButton = graphState.shouldShowBackButton
                        ) {

                        }
                    }
                ) {
                    GraphBuilder(graphState)
                }
            }
        }
    }
}

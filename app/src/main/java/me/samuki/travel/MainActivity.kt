package me.samuki.travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.samuki.core.settings.WasOnBoardingSeen
import me.samuki.navigation.destinations.Destination
import me.samuki.navigation.graph.GraphBuilder
import me.samuki.navigation.graph.rememberGraphState
import me.samuki.travel.ui.theme.TravelTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var destinations: Set<@JvmSuppressWildcards Destination>

    @Inject
    lateinit var wasOnBoardingSeen: WasOnBoardingSeen

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val graphState = rememberGraphState(
                navController = navController,
                destinations = destinations,
                wasOnBoardingSeen = wasOnBoardingSeen.value
            )

            TravelTheme {
                Scaffold {
                    GraphBuilder(graphState, Modifier.padding(it))
                }
            }
        }
    }
}

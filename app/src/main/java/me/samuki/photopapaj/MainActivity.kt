package me.samuki.photopapaj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.samuki.navigation.AppNavigation
import me.samuki.navigation.destinations.Destination
import me.samuki.photopapaj.ui.theme.PhotoPapajTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var destinations: Set<@JvmSuppressWildcards Destination>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            PhotoPapajTheme {
                // A surface container using the 'background' color from the theme
                destinations.first().BuildDestination(navigation = AppNavigation(navController))
            }
        }
    }
}

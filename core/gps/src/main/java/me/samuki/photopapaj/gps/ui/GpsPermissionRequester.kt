package me.samuki.photopapaj.gps.ui

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@ExperimentalPermissionsApi
@Composable
fun GpsPermissionRequester(
    Granted: @Composable () -> Unit,
    Denied: @Composable (() -> Unit) -> Unit,
) {
    val permissionState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )
    if (permissionState.permissions.all { it.status == PermissionStatus.Granted }) {
        Granted()
    } else {
        Denied {
            permissionState.launchMultiplePermissionRequest()
        }
    }
}

package me.samuki.photopapaj.gps.ui.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityRetainedComponent::class)
class GpsModule {
    @Provides
    fun fusedLocationClient(@ApplicationContext context: Context) = LocationServices.getFusedLocationProviderClient(context)
}

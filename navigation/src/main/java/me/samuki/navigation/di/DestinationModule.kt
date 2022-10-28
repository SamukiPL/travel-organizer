package me.samuki.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import me.samuki.navigation.destinations.Destination
import me.samuki.navigation.destinations.OnBoarding

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DestinationModule {
    @Binds
    @IntoSet
    abstract fun onBoarding(onBoarding: OnBoarding): Destination
}

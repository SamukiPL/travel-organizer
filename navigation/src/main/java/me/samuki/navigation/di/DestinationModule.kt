package me.samuki.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import me.samuki.navigation.destinations.*

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DestinationModule {
    @Binds
    @IntoSet
    abstract fun onBoarding(onBoarding: OnBoarding): Destination

    @Binds
    @IntoSet
    abstract fun journeyName(journeyName: JourneyName): Destination

    @Binds
    @IntoSet
    abstract fun editJourneyName(editJourneyName: EditJourneyName): Destination

    @Binds
    @IntoSet
    abstract fun journeyDetails(journeyDetails: JourneyDetails): Destination
}

package me.samuki.journeyName.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.journeyName.data.network.JourneyNameEndpoint
import me.samuki.journeyName.data.network.MockJourneyNameEndpoint

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class JourneyNameMockModule {
    @Binds
    abstract fun journeyNameEndpoint(mockJourneyNameEndpoint: MockJourneyNameEndpoint): JourneyNameEndpoint
}

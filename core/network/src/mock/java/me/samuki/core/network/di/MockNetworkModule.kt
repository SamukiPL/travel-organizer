package me.samuki.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.samuki.core.network.endpoint.JourneyEndpoint
import me.samuki.core.network.endpoint.MockJourneyEndpoint

@Module
@InstallIn(SingletonComponent::class)
abstract class MockNetworkModule {
    @Binds
    abstract fun mockJourneyEndpoint(mockJourneyEndpoint: MockJourneyEndpoint): JourneyEndpoint
}

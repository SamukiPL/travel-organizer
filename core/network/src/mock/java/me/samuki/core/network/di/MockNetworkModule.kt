package me.samuki.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.samuki.core.network.endpoint.JourneyEndpoint
import me.samuki.core.network.endpoint.MockJourneyEndpoint
import me.samuki.core.network.endpoint.MockStageEndpoint
import me.samuki.core.network.endpoint.StageEndpoint

@Module
@InstallIn(SingletonComponent::class)
abstract class MockNetworkModule {
    @Binds
    abstract fun mockJourneyEndpoint(mockJourneyEndpoint: MockJourneyEndpoint): JourneyEndpoint

    @Binds
    abstract fun mockStageEndpoint(mockStageEndpoint: MockStageEndpoint): StageEndpoint
}

package me.samuki.journeyName.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.journeyName.data.DataJourneyNameRepository
import me.samuki.journeyName.domain.JourneyNameRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class JourneyNameDataModule {
    @Binds
    abstract fun journeyNameRepository(dataJourneyNameRepository: DataJourneyNameRepository): JourneyNameRepository
}

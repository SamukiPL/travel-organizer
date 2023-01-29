package me.samuki.journeyDetails.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import me.samuki.journeyDetails.data.DataJourneyDetailsRepository
import me.samuki.journeyDetails.domain.JourneyDetailsRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class JourneyDetailsDataModule {
    @Binds
    @ViewModelScoped
    abstract fun journeyDetailsRepository(dataJourneyDetailsRepository: DataJourneyDetailsRepository): JourneyDetailsRepository
}

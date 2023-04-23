package me.samuki.addstage.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.addstage.data.DataAddStageRepository
import me.samuki.addstage.domain.AddStageRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AddStageDataModule {
    @Binds
    abstract fun bindAddStageRepository(repository: DataAddStageRepository): AddStageRepository
}

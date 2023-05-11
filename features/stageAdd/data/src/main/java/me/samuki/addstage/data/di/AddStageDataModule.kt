package me.samuki.stageadd.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.stageadd.data.DataStageAddRepository
import me.samuki.stageadd.domain.StageAddRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class StageAddDataModule {
    @Binds
    abstract fun bindStageAddRepository(repository: DataStageAddRepository): StageAddRepository
}

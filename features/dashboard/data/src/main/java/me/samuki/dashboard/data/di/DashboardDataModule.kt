package me.samuki.dashboard.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.dashboard.data.DataDashboardRepository
import me.samuki.dashboard.domain.DashboardRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DashboardDataModule {
    @Binds
    abstract fun dashboardRepository(dataDashboardRepository: DataDashboardRepository): DashboardRepository
}

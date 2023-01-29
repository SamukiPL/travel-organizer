package me.samuki.dashboard.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import me.samuki.dashboard.data.DataDashboardRepository
import me.samuki.dashboard.domain.DashboardRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DashboardDataModule {
    @Binds
    @ViewModelScoped
    abstract fun dashboardRepository(dataDashboardRepository: DataDashboardRepository): DashboardRepository
}

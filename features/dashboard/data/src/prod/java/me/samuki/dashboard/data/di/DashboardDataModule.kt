package me.samuki.dashboard.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.dashboard.data.DashboardEndpoint
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object DashboardDataModule {
    @Provides
    fun dashboardEndpoint(retrofit: Retrofit): DashboardEndpoint = retrofit.create()
}

package me.samuki.journeyName.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import me.samuki.journeyName.data.network.JourneyNameEndpoint
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ActivityRetainedComponent::class)
object JourneyNameProdModule {
    @Binds
    fun journeyNameEndpoint(retrofit: Retrofit): JourneyNameEndpoint = retrofit.create()
}

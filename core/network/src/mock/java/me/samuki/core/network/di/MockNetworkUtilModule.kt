package me.samuki.core.network.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.plugins.logging.Logger

@Module
@InstallIn(SingletonComponent::class)
object MockNetworkUtilModule {
    @Provides
    @NetworkLogger
    fun networkLogger(): Logger = object : Logger {
        override fun log(message: String) {
           Log.d("NETWORK", message)
        }
    }
}

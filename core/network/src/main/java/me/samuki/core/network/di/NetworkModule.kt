package me.samuki.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    fun ktorClient(): HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        install(Logging)

        engine {
            maxConnectionsCount = 10_000

            https {
                serverName = "TODO"
            }
        }
    }
}

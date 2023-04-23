package me.samuki.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    fun ktorClient(@NetworkLogger networkLogger: Logger): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            logger = networkLogger
            level = LogLevel.ALL
        }

        engine {
            connectTimeout = 10_000
        }
    }

    @Provides
    @XmlQualifier
    fun xmlKtorClient(@NetworkLogger networkLogger: Logger): HttpClient = HttpClient(Android) {
        install(Logging) {
            logger = networkLogger
            level = LogLevel.ALL
        }

        engine {
            connectTimeout = 10_000
        }
    }
}

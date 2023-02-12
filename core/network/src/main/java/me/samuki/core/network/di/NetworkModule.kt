package me.samuki.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import io.ktor.serialization.kotlinx.xml.xml

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    fun ktorClient(): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            level = LogLevel.ALL
        }

        engine {
            connectTimeout = 10_000
        }
    }

    @Provides
    @XmlQualifier
    fun xmlKtorClient(): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            xml()
        }
        install(Logging) {
            level = LogLevel.ALL
        }

        engine {
            connectTimeout = 10_000
        }
    }
}

package me.samuki.core.database.di

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.samuki.core.database.Database
import me.samuki.core.database.JourneyQueries
import me.samuki.core.database.ShelterQueries
import me.samuki.core.database.SightQueries
import me.samuki.core.database.StageQueries
import me.samuki.core.database.converters.LocalDateTimeAdapter
import me.samuki.core.database.converters.StageTypeAdapter
import me.samuki.core.database.entity.StorageJourney
import me.samuki.core.database.entity.StorageStage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun database(@ApplicationContext context: Context): Database {
        val driver = AndroidSqliteDriver(Database.Schema, context, "travel.db")
        return Database(
            driver,
            StorageJourneyAdapter = StorageJourney.Adapter(
                lastRevisionAdapter = LocalDateTimeAdapter()
            ),
            StorageStageAdapter = StorageStage.Adapter(
                typeAdapter = StageTypeAdapter()
            )
        )
    }

    @Provides
    fun journeyQueries(database: Database): JourneyQueries = database.storageJourneyQueries

    @Provides
    fun stageQueries(database: Database): StageQueries = database.storageStageQueries

    @Provides
    fun shelterQueries(database: Database): ShelterQueries = database.storageShelterQueries

    @Provides
    fun sightQueries(database: Database): SightQueries = database.storageSightQueries
}

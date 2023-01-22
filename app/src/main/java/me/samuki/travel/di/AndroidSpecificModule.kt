package me.samuki.travel.di

import android.content.Context
import android.content.SharedPreferences
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AndroidSpecificModule {
    @Provides
    fun sharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("TODO_NAME", Context.MODE_PRIVATE)

    @Provides
    fun settings(sharedPreferences: SharedPreferences): Settings =
        SharedPreferencesSettings(sharedPreferences)
}

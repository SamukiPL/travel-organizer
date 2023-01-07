package me.samuki.core.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @IoCoroutineContext
    @Provides
    fun ioCoroutineContext(): CoroutineContext = Dispatchers.IO
}

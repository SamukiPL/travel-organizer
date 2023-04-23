package me.samuki.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.samuki.core.data.DataUrlScrappingRepository
import me.samuki.core.domain.urlScrapping.UrlScrappingRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun urlScrappingRepository(dataUrlScrappingRepository: DataUrlScrappingRepository): UrlScrappingRepository
}

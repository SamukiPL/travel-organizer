package me.samuki.core.data

import me.samuki.core.data.mapper.toDomain
import me.samuki.core.data.network.NetworkScrapperDataSource
import me.samuki.core.domain.model.UrlMetadata
import me.samuki.core.domain.urlScrapping.UrlScrappingRepository
import javax.inject.Inject

class DataUrlScrappingRepository @Inject constructor(
    private val networkScrapperDataSource: NetworkScrapperDataSource
) : UrlScrappingRepository {
    override suspend fun getUrlMetadata(url: String): Result<UrlMetadata> = try {
        networkScrapperDataSource.scrapWebsiteForMetaDataProperties(url)
            .run { Result.success(toDomain()) }
    } catch (e: Throwable) {
        Result.failure(e)
    }

}

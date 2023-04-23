package me.samuki.core.domain.urlScrapping

import me.samuki.core.domain.model.UrlMetadata

interface UrlScrappingRepository {
    suspend fun getUrlMetadata(url: String): Result<UrlMetadata>
}

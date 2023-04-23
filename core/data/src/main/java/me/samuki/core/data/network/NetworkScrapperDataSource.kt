package me.samuki.core.data.network

import me.samuki.core.network.endpoint.UrlEndpoint
import me.samuki.core.network.model.ApiUrlMetadata
import javax.inject.Inject

class NetworkScrapperDataSource @Inject constructor(
    private val urlEndpoint: UrlEndpoint
) {

    suspend fun scrapWebsiteForMetaDataProperties(url: String): ApiUrlMetadata = urlEndpoint.getWebsiteHtml(url).run {
        Regex(SCRAP_REGEX)
            .findAll(this)
            .map { matchResult ->
                matchResult.groupValues.chunked(CHUNK_SIZE)
            }
            .flatten()
            .toList()
            .associate {
                Pair(it[1], it[2])
            }.let {
                ApiUrlMetadata(
                    url = it[OG_URL_PROPERTY],
                    siteName = it[OG_SITE_NAME_PROPERTY],
                    image = it[OG_IMAGE_PROPERTY]
                )
            }
    }

    companion object {
        const val SCRAP_REGEX = "<meta\\s+property=\"og:([^\"]+)\"\\s+content=\"([^\"]*)\"\\s*\\/?>"

        /**
         * Our regex has 2 capturing groups, so it will return data in fashion like:
         * [found string, property, content]
         */
        const val CHUNK_SIZE = 3

        const val OG_URL_PROPERTY = "url"
        const val OG_SITE_NAME_PROPERTY = "site_name"
        const val OG_IMAGE_PROPERTY = "image"
    }
}

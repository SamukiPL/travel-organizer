package me.samuki.core.data.network

import me.samuki.core.network.endpoint.UrlEndpoint
import me.samuki.core.network.model.ApiMetadata
import javax.inject.Inject

class NetworkScrapperDataSource @Inject constructor(
    private val urlEndpoint: UrlEndpoint
) {

    suspend fun scrapWebsiteForMetaDataProperties(url: String): ApiMetadata = urlEndpoint.getWebsiteHtml(url).run {
        Regex(SCRAP_REGEX)
            .findAll(this)
            .map { matchResult ->
                matchResult.groupValues.chunked(CHUNK_SIZE)
            }
            .flatten()
            .toList()
            .filter { chunk ->
                chunk.first().contains(FILTER_CONTENT)
                        && chunk.first().contains(FILTER_PROPERTY)
            }
            .associate {
                Pair(it[1], it[2])
            }.let {
                ApiMetadata(
                    url = it[OG_URL_PROPERTY],
                    siteName = it[OG_SITE_NAME_PROPERTY],
                    image = it[OG_IMAGE_PROPERTY]
                )
            }
    }

    companion object {
        const val SCRAP_REGEX = "<meta(?=.*?property=\"(og:.*?)\")(?=.*?content=\"(.*?)\").*?>"

        /**
         * Our regex has 2 capturing groups, so it will return data in fashion like:
         * [found string, property, content]
         */
        const val CHUNK_SIZE = 3

        const val FILTER_CONTENT = "content"
        const val FILTER_PROPERTY = "property=\"og:"

        const val OG_URL_PROPERTY = "og:url"
        const val OG_SITE_NAME_PROPERTY = "og:site_name"
        const val OG_IMAGE_PROPERTY = "og:image"
    }
}

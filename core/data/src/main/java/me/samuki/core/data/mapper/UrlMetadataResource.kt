package me.samuki.core.data.mapper

import me.samuki.core.domain.model.UrlMetadata
import me.samuki.core.network.model.ApiUrlMetadata

fun ApiUrlMetadata.toDomain() = UrlMetadata(
    url,
    siteName,
    image
)

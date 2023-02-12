package me.samuki.core.network.endpoint

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Url
import me.samuki.core.network.di.XmlQualifier
import javax.inject.Inject

class UrlEndpoint @Inject constructor(
    @XmlQualifier private val ktor: HttpClient
) {
    suspend fun getWebsiteHtml(url: String) = ktor.get(Url(url)).bodyAsText()
}

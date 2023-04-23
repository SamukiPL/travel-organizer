package me.samuki.core.domain.urlScrapping

import kotlinx.coroutines.withContext
import me.samuki.core.domain.di.IoCoroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetUrlMetadata @Inject constructor(
    private val repository: UrlScrappingRepository,
    @IoCoroutineContext private val coroutineContext: CoroutineContext
) {
    suspend operator fun invoke(url: String) = withContext(coroutineContext) {
        repository.getUrlMetadata(url)
    }
}

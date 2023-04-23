package me.samuki.core.data.network

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beOfType
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import me.samuki.core.network.endpoint.UrlEndpoint
import me.samuki.core.network.model.ApiUrlMetadata

class NetworkScrapperDataSourceTest : BehaviorSpec({

    lateinit var underTest: NetworkScrapperDataSource

    val urlEndpoint: UrlEndpoint = mockk()

    beforeSpec {
        clearAllMocks()
    }

    given("NetworkScrapperDataSource") {
        underTest = NetworkScrapperDataSource(urlEndpoint)

        and("urlEndpoint returns \"correct\" website") {
            coEvery { urlEndpoint.getWebsiteHtml(any()) } returns TEST_HTML

            `when`("scrapWebsiteForMetaDataProperties gets invoked") {
                val result = underTest.scrapWebsiteForMetaDataProperties("")

                then("ulrEndpoint.getWebsiteHtml should be invoked only once") {
                    coVerify(exactly = 1) { urlEndpoint.getWebsiteHtml(any()) }
                }
                then("result should be ApiMetadata") {
                    result should beOfType(ApiUrlMetadata::class)
                }
                then("result.url should be same as test url") {
                    result.url shouldBe TEST_URL
                }
                then("result.siteName should be same as test site name") {
                    result.siteName shouldBe TEST_SITE_NAME
                }
                then("result.image should be same as test image url") {
                    result.image shouldBe TEST_IMAGE_URL
                }
            }
        }

        and("urlEndpoint returns website without metadata") {
            coEvery { urlEndpoint.getWebsiteHtml(any()) } returns ""

            `when`("scrapWebsiteForMetaDataProperties gets invoked") {
                val result = underTest.scrapWebsiteForMetaDataProperties("")

                then("result.url should be same as test url") {
                    result.url shouldBe null
                }
                then("result.siteName should be same as test site name") {
                    result.siteName shouldBe null
                }
                then("result.image should be same as test image url") {
                    result.image shouldBe null
                }
            }
        }

        and("urlEndpoint throws Throwable") {
            coEvery { urlEndpoint.getWebsiteHtml(any()) } throws Throwable()

            `when`("scrapWebsiteForMetaDataProperties gets invoked") {
                then("underTest propagates throwable thrown by urlEndpoint") {
                    shouldThrow<Throwable> {
                        underTest.scrapWebsiteForMetaDataProperties("")
                    }
                }
            }
        }
    }
})

const val TEST_URL = "https://github.com/SamukiPL/convention-example-project"
const val TEST_SITE_NAME = "GitHub"
const val TEST_IMAGE_URL = "test image url"

const val TEST_HTML = "<meta property=\"fb:app_id\" content=\"1401488693436528\">\n" +
        "    <meta name=\"apple-itunes-app\" content=\"app-id=1477376905\" />\n" +
        "      <meta name=\"twitter:image:src\" content=\"https://opengraph.githubassets.com/ad9f8cdb30b01bcca52bfc04a344b8405eadc6d64e0b891be7c1f1a0084443f8/SamukiPL/convention-example-project\" /><meta name=\"twitter:site\" content=\"@github\" /><meta name=\"twitter:card\" content=\"summary_large_image\" /><meta name=\"twitter:title\" content=\"SamukiPL/convention-example-project\" /><meta name=\"image\" content=\"Contribute to SamukiPL/convention-example-project development by creating an account on GitHub.\" />\n" +
        "      <meta property=\"og:image\" content=\"$TEST_IMAGE_URL\" /><meta property=\"og:image:alt\" content=\"Contribute to SamukiPL/convention-example-project development by creating an account on GitHub.\" /><meta property=\"og:image:width\" content=\"1200\" /><meta property=\"og:image:height\" content=\"600\" /><meta property=\"og:site_name\" content=\"$TEST_SITE_NAME\" /><meta property=\"og:type\" content=\"object\" /><meta property=\"og:title\" content=\"SamukiPL/convention-example-project\" /><meta property=\"og:url\" content=\"$TEST_URL\" /><meta property=\"og:description\" content=\"Contribute to SamukiPL/convention-example-project development by creating an account on GitHub.\" />\n" +
        "      \n" +
        "    <link rel=\"assets\" href=\"https://github.githubassets.com/\">\n" +
        "      <link rel=\"shared-web-socket\" href=\"wss://alive.github.com/_sockets/u/22870999/ws?session=eyJ2IjoiVjMiLCJ1IjoyMjg3MDk5OSwicyI6OTI1Mjc5ODg4LCJjIjoxNzU5Nzk4NjUyLCJ0IjoxNjc1OTc1MTEwfQ==--7775e27d5c327a10b58501dfe737114592ef441037c3c59a2568aa6e1dddc769\" data-refresh-url=\"/_alive\" data-session-id=\"422c10e151548ee17b15c0a2c678738a407e2fc1aced892355fd5356241bc723\">\n" +
        "      <link rel=\"shared-web-socket-src\" href=\"/assets-cdn/worker/socket-worker-d7c2fe14563a.js\">"

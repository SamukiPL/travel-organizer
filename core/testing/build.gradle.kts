plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
}

android {
    namespace = "me.samuki.core.testing"
}

dependencies {
    val kotestVersion = "5.5.4"
    val mockkVersion = "1.13.3"

    api("io.kotest:kotest-runner-junit5:$kotestVersion")
    api("io.kotest:kotest-assertions-core:$kotestVersion")
    api("io.kotest:kotest-property:$kotestVersion")

    api("io.mockk:mockk:$mockkVersion")
}

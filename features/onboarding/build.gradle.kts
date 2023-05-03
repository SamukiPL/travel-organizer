plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.feature")
    id("me.samuki.hilt")
    id("me.samuki.hilt.compose")
}

android {
    namespace = "me.samuki.onboarding"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:settings"))

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.lottie)
}

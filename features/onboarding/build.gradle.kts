plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.feature")
    id("me.samuki.hilt")
    id("me.samuki.hilt.compose")
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:settings"))

    implementation("com.google.accompanist:accompanist-pager:0.26.5-rc")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.26.5-rc")

    implementation("com.airbnb.android:lottie-compose:5.2.0")
}

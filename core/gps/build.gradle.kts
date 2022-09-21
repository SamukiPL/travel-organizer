plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.hilt")
}

dependencies {
    api("com.google.accompanist:accompanist-permissions:0.26.3-beta")
    implementation("com.google.android.gms:play-services-location:20.0.0")
}

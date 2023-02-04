plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.hilt")
}

android {
    namespace = "me.samuki.core.presentation"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
}

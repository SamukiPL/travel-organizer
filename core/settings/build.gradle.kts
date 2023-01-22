plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
}

android {
    namespace = "me.samuki.core.settings"
}

dependencies {
    implementation(project(":core:common"))

    implementation("com.russhwolf:multiplatform-settings-no-arg:1.0.0-RC")
}

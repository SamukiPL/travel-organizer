plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
}

android {
    namespace = "me.samuki.core.settings"
}

dependencies {
    implementation(project(":core:common"))

    implementation(libs.settings.no.arg)
}

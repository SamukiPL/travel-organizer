plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
}

android {
    namespace = "me.samuki.travel.common"
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    testImplementation(project(":core:testing"))
}

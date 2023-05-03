plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "me.samuki.core.network"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    mockImplementation(project(":core:database"))


    api(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.logging)
}

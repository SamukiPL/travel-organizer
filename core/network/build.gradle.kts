plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "me.samuki.core.network"
}

dependencies {
    val ktorVersion="2.2.1"

    implementation(project(":core:common"))
    implementation(project(":core:model"))

    mockImplementation(project(":core:database"))

    api("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-xml:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
}

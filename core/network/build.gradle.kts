plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
    id("kotlinx-serialization")
}

dependencies {
    val ktorVersion="2.2.1"

    implementation(project(":core:common"))

    api("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
}

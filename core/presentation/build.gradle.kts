plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.hilt")
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
}

plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
}

dependencies {
    implementation(project(":core:common"))
    api(project(":core:settings"))
}

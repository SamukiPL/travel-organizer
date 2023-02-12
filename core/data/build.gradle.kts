plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "me.samuki.core.data"
}

dependencies {
    api(project(":core:common"))
    api(project(":core:network"))
    api(project(":core:database"))
    api(project(":core:domain"))

    testImplementation(project(":core:testing"))
}

plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
    id("com.google.devtools.ksp")
    id("com.squareup.sqldelight")
}

android {
    namespace = "me.samuki.core.database"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    api("com.squareup.sqldelight:android-driver:1.5.4")
    api("com.squareup.sqldelight:coroutines-extensions:1.5.4")

    testImplementation(project(":core:testing"))
}

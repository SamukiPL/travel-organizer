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
    implementation(project(":core:domain"))

    implementation("com.squareup.sqldelight:android-driver:1.5.4")

    testImplementation(project(":core:testing"))
}

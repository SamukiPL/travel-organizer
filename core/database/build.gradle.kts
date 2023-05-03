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

    api(libs.sqldelight.android.driver)
    api(libs.sqldelight.coroutines.extensions)

    testImplementation(project(":core:testing"))
}

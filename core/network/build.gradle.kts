plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
}

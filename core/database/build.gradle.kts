plugins {
    id("me.samuki.library")
    id("me.samuki.hilt")
    id("com.google.devtools.ksp")
}

dependencies {
    val room_version = "2.4.3"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
}

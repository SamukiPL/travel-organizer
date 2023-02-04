plugins {
    id("me.samuki.layers.data")
}

android {
    namespace = "me.samuki.journeyName.data"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:database"))
}

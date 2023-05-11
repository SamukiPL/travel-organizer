plugins {
    id("me.samuki.layers.data")
}

dependencies {
    api(project(":core:network"))
}

android {
    namespace = "me.samuki.stageadd.data"
}

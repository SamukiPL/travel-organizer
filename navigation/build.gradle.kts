plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.hilt")
    id("me.samuki.hilt.compose")
}

android {
    namespace = "me.samuki.navigation"
}

dependencies {
    implementation(project(":core:presentation"))
    implementation(project(":core:ui"))
    implementation(project(":features:onboarding"))
    implementation(project(":features:dashboard:presentation"))
    implementation(project(":features:journeyName:presentation"))
    implementation(project(":features:journeyDetails:presentation"))
    implementation(project(":features:addStage:presentation"))
}

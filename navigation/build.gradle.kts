plugins {
    id("me.samuki.library")
    id("me.samuki.library.compose")
    id("me.samuki.hilt")
    id("me.samuki.hilt.compose")
}

dependencies {
    implementation(project(":features:onboarding"))
    implementation(project(":features:journeyDetails:presentation"))
    implementation(project(":features:journeyName:presentation"))
    implementation(project(":features:addStage:presentation"))
}

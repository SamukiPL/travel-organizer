pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "Travel"
include(":app")
include(":navigation")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:presentation")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:settings")
include(":core:ui")
include(":core:testing")
include(":features:onboarding")
include(":features:dashboard:presentation")
include(":features:dashboard:data")
include(":features:dashboard:domain")
include(":features:journeyDetails:domain")
include(":features:journeyDetails:data")
include(":features:journeyDetails:presentation")
include(":features:journeyName:data")
include(":features:journeyName:domain")
include(":features:journeyName:presentation")
include(":features:addStage:domain")
include(":features:addStage:data")
include(":features:addStage:presentation")

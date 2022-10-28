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
    }
}

rootProject.name = "Photo Papaj"
include(":app")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:presentation")
include(":features:onboarding")
include(":features:newStamp:data")
include(":features:newStamp:domain")
include(":features:newStamp:presentation")
include(":features:dashboard:presentation")
include(":features:dashboard:data")
include(":features:dashboard:domain")
include(":core:network")
include(":core:ui")
include(":navigation")

plugins {
    id("me.samuki.application")
    id("me.samuki.application.compose")
    id("me.samuki.hilt")
    id("me.samuki.hilt.compose")
}

android {
    namespace = "me.samuki.travel"

    defaultConfig {
        applicationId = "me.samuki.travel"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.splashscreen)

    implementation(libs.settings.multiplatform)
}

@file:Suppress("UnstableApiUsage")

plugins {
    id("githubme.android.application")
    id("githubme.android.application.compose")
    id("githubme.android.hilt")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.csmprojects.githubme"

    defaultConfig {
        applicationId = "com.csmprojects.githubme"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":feature:login"))
    implementation(project(":feature:users"))
    implementation(project(":feature:profile"))
    implementation(project(":core:common"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
}
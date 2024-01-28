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
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.espresso.core)
    testImplementation(libs.androidx.test.rules)
    testImplementation(libs.androidx.test.runner)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.junit4)
    testImplementation(libs.kotlinx.coroutines.test)

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.junit4)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}
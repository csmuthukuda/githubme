@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("githubme.android.feature")
    id("githubme.android.library.compose")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.csmprojects.feature.githubme.login"
}

dependencies {
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation(project(":core:common"))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.util)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
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
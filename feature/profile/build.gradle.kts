@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("githubme.android.feature")
    id("githubme.android.library.compose")
}

android {
    namespace = "com.csmprojects.githubme.feature.profile"
}

dependencies {

    implementation(project(":core:common"))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.coil.kt.compose)

    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.espresso.core)
    testImplementation(libs.androidx.test.rules)
    testImplementation(libs.androidx.test.runner)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.junit4)
    testImplementation(libs.kotlinx.coroutines.test)

}
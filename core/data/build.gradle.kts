@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("githubme.android.library")
    id("githubme.android.hilt")
    id("kotlinx-serialization")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.csmprojects.githubme.core.data"
}

dependencies {

    implementation(project(":core:common"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)

    implementation(libs.play.services.auth)
    implementation(libs.firebase.auth)
}
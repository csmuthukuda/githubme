@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("githubme.android.library")
}

android {
    namespace = "com.csmprojects.githubme.core.common"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
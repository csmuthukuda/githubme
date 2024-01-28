@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("githubme.android.library")
    id("githubme.android.hilt")
}

android {
    namespace = "com.csmprojects.githubme.core.domain"
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:common"))
}
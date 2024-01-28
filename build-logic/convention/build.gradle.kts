
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    `kotlin-dsl`
}

group = "com.csmprojects.githubme.buildlogic"

java {
    // Up to Java 11 APIs are available through desugaring
    // https://developer.android.com/studio/write/java11-minimal-support-table
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "githubme.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "githubme.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "githubme.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "githubme.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "githubme.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "githubme.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

    }
}

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

rootProject.name = "GitHubMe"
include(":app")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":feature:login")
include(":feature:users")
include(":feature:profile")

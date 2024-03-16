pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
//        maven(url = "E:\\Android Projects\\Side projects\\InitiateAndroid\\InitiateDependency\\src\\main\\java\\")
//        maven(url = "https://localhost:8080")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "InitiateAndroid"
include(":app")
include(":InitiateAndroid")
include(":InitiateDependency")

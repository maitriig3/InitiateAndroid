// Top-level build file where you can add configuration options common to all sub-projects/modules.
//import in_.mai3.initiateDependency.classpathForPlugin
//import in_.mai3.initiateDependency.DaggerHilt.Companion.HILT_PLUGIN_ID
//import in_.mai3.initiateDependency.DaggerHilt.Companion.LATEST_VERSION


plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
//    id(in_.mai3.initiateDependency.DaggerHilt.Companion.HILT_PLUGIN_ID) version in_.mai3.initiateDependency.DaggerHilt.Companion.LATEST_VERSION apply false
}

buildscript{
    dependencies{
        classpath(files("D:/1Projects/0Android/Side projects/InitiateAndroid/InitiateDependency/libs/InitiateDependency.jar"))
//        classpath(classpathForPlugin())
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51")
    }
}
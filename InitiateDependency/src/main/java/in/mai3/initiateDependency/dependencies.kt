package `in`.mai3.initiateDependency

import org.gradle.api.artifacts.dsl.DependencyHandler


internal fun DependencyHandler.implementation(dependency: Any) {
    this.add("implementation", dependency)
}

internal fun DependencyHandler.kapt(dependency: Any) {
    this.add("kapt", dependency)
}

internal fun DependencyHandler.annotationProcessor(dependency: Any) {
    this.add("annotationProcessor", dependency)
}

internal fun DependencyHandler.testImplementation(value: Any) {
    this.add("testImplementation", value)
}

internal fun DependencyHandler.testKapt(dependency: Any) {
    this.add("testKapt", dependency)
}

internal fun DependencyHandler.testAnnotationProcessor(dependency: Any) {
    this.add("testAnnotationProcessor", dependency)
}

internal fun DependencyHandler.androidTestImplementation(value: Any) {
    this.add("androidTestImplementation", value)
}

internal fun DependencyHandler.androidTestKapt(dependency: Any) {
    this.add("androidTestKapt", dependency)
}

internal fun DependencyHandler.androidTestAnnotationProcessor(dependency: Any) {
    this.add("androidTestAnnotationProcessor", dependency)
}
package com.mai3.initiateDependency

import org.gradle.api.artifacts.dsl.DependencyHandler

class Lifecycle(private val dependencyHandler: DependencyHandler) {


    fun liveDataKtxVersion2_7_0() {
        dependencyHandler.implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    }

}
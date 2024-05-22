package in_.mai3.initiateDependency

import org.gradle.api.artifacts.dsl.DependencyHandler

//https://dagger.dev/hilt/gradle-setup

class DaggerHilt(private val dependencyHandler: DependencyHandler) {


    fun basicRequired(version: String = LATEST_VERSION): DaggerHilt{
        implementation(version)
        kapt(version)
        return this
    }


    /**
     * implementation("com.google.dagger:hilt-android:$version")
     * kapt("com.google.dagger:hilt-android-compiler:$version")
     *
     * Configure kapt to correct error types by setting correctErrorTypes to true.
     * kapt {
     *  correctErrorTypes true
     * }
     *
     *
     */
    fun implementationWithKapt(version: String = LATEST_VERSION): DaggerHilt {
        implementation(version)
        kapt(version)
        return this@DaggerHilt
    }

    /**
     * implementation("com.google.dagger:hilt-android:$version")
     * annotationProcessor("com.google.dagger:hilt-android-compiler:$version")
     */
    fun implementationWithAnnotationProcessor(version: String = LATEST_VERSION): DaggerHilt {
        implementation(version)
        annotationProcessor(version)
        return this@DaggerHilt
    }

    /**
     * implementation("com.google.dagger:hilt-android:$version")
     */
    fun implementation(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.implementation("com.google.dagger:hilt-android:$version")
        return this@DaggerHilt
    }

    /**
     * kapt("com.google.dagger:hilt-android-compiler:$version")
     *
     *
     * Configure kapt to correct error types by setting correctErrorTypes to true.
     *
     * kapt {
     *  correctErrorTypes true
     * }
     *
     *
     */
    fun kapt(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.kapt("com.google.dagger:hilt-android-compiler:$version")
        return this@DaggerHilt
    }

    /**
     * annotationProcessor("com.google.dagger:hilt-android-compiler:$version")
     */
    fun annotationProcessor(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.annotationProcessor("com.google.dagger:hilt-android-compiler:$version")
        return this@DaggerHilt
    }


    /**
     * testImplementation("com.google.dagger:hilt-android-testing:$version")
     * testKapt("com.google.dagger:hilt-android-compiler:$version")
     */
    fun testImplementationWithKapt(version: String = LATEST_VERSION): DaggerHilt {
        testImplementation(version)
        testKapt(version)
        return this@DaggerHilt
    }

    /**
     * testImplementation("com.google.dagger:hilt-android-testing:$version")
     * testAnnotationProcessor("com.google.dagger:hilt-android-compiler:$version")
     */
    fun testImplementationWithAnnotationProcessor(version: String = LATEST_VERSION): DaggerHilt {
        testImplementation(version)
        testAnnotationProcessor(version)
        return this@DaggerHilt
    }

    /**
     * testImplementation("com.google.dagger:hilt-android-testing:$version")
     */
    fun testImplementation(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.testImplementation("com.google.dagger:hilt-android-testing:$version")
        return this@DaggerHilt
    }

    /**
     * testKapt("com.google.dagger:hilt-android-compiler:$version")
     */
    fun testKapt(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.testKapt("com.google.dagger:hilt-android-compiler:$version")
        return this@DaggerHilt
    }

    /**
     * testAnnotationProcessor("com.google.dagger:hilt-android-compiler:$version")
     */
    fun testAnnotationProcessor(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.testAnnotationProcessor("com.google.dagger:hilt-android-compiler:$version")
        return this@DaggerHilt
    }

    /**
     * androidTestImplementation("com.google.dagger:hilt-android-testing:$version")
     * androidTestKapt("com.google.dagger:hilt-android-compiler:$version")
     */
    fun androidTestImplementationWithKapt(version: String = LATEST_VERSION): DaggerHilt {
        androidTestImplementation(version)
        androidTestKapt(version)
        return this@DaggerHilt
    }

    /**
     * androidTestImplementation("com.google.dagger:hilt-android-testing:$version")
     * androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:$version")
     */
    fun androidTestImplementationWithAnnotationProcessor(version: String = LATEST_VERSION): DaggerHilt {
        androidTestImplementation(version)
        androidTestAnnotationProcessor(version)
        return this@DaggerHilt
    }

    /**
     * androidTestImplementation("com.google.dagger:hilt-android-testing:$version")
     */
    fun androidTestImplementation(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.androidTestImplementation("com.google.dagger:hilt-android-testing:$version")
        return this@DaggerHilt
    }

    /**
     * androidTestKapt("com.google.dagger:hilt-android-compiler:$version")
     */
    fun androidTestKapt(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.androidTestKapt("com.google.dagger:hilt-android-compiler:$version")
        return this@DaggerHilt
    }

    /**
     * androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:$version")
     */
    fun androidTestAnnotationProcessor(version: String = LATEST_VERSION): DaggerHilt {
        dependencyHandler.androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:$version")
        return this@DaggerHilt
    }


    companion object {
        const val VERSION_2_51 = "2.51"
        const val VERSION_2_46 = "2.46"
        const val LATEST_VERSION = VERSION_2_51


        /**
         * Hilt Gradle Plugin
         */

        const val HILT_PLUGIN_ID = "com.google.dagger.hilt.android"
    }

}

fun classpathForHiltPlugin(version: String = DaggerHilt.LATEST_VERSION): String {
    return "com.google.dagger:hilt-android-gradle-plugin:$version"
}





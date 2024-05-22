package in_.mai3.initiateDependency

import org.gradle.api.artifacts.dsl.DependencyHandler

//https://developer.android.com/guide/navigation#kts
class Navigation(private val dependencyHandler: DependencyHandler) {


    fun basicRequired(version: String = LATEST_VERSION): Navigation{
        implementationKotlin(version)
        return this
    }


    /**
     * implementation("androidx.navigation:navigation-fragment:$version")
     * implementation("androidx.navigation:navigation-ui:$version")
     */
    fun implementationJava(version: String = LATEST_VERSION): Navigation{
        implementationFragmentJava(version)
        implementationUIJava(version)
        return this
    }


    /**
     * implementation("androidx.navigation:navigation-fragment:$version")
     */
    fun implementationFragmentJava(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.implementation("androidx.navigation:navigation-fragment:$version")
        return this
    }

    /**
     * implementation("androidx.navigation:navigation-ui:$version")
     */
    fun implementationUIJava(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.implementation("androidx.navigation:navigation-ui:$version")
        return this
    }


    /**
     * implementation("androidx.navigation:navigation-fragment-ktx:$version")
     * implementation("androidx.navigation:navigation-ui-ktx:$version")
     */
    fun implementationKotlin(version: String = LATEST_VERSION): Navigation{
        implementationFragmentKotlin(version)
        implementationUIKotlin(version)
        return this
    }


    /**
     * implementation("androidx.navigation:navigation-fragment-ktx:$version")
     */
    fun implementationFragmentKotlin(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.implementation("androidx.navigation:navigation-fragment-ktx:$version")
        return this
    }

    /**
     * implementation("androidx.navigation:navigation-ui-ktx:$version")
     */
    fun implementationUIKotlin(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.implementation("androidx.navigation:navigation-ui-ktx:$version")
        return this
    }

    /**
     * Feature module support
     *
     * implementation("androidx.navigation:navigation-dynamic-features-fragment:$version")
     */
    fun implementationFeatureModule(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.implementation("androidx.navigation:navigation-dynamic-features-fragment:$version")
        return this
    }

//    // Testing Navigation
//    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
//

    /**
     * androidTestImplementation("androidx.navigation:navigation-testing:$version")
     */
    fun androidTestImplementation(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.androidTestImplementation("androidx.navigation:navigation-testing:$version")
        return this
    }

    /**
     * Jetpack Compose Integration
     *
     * implementation("androidx.navigation:navigation-compose:$version")
     */
    fun implementationJetpackCompose(version: String = LATEST_VERSION): Navigation{
        dependencyHandler.implementation("androidx.navigation:navigation-compose:$version")
        return this
    }



    companion object{
        const val VERSION_2_7_7 ="2.7.7"
        const val LATEST_VERSION = VERSION_2_7_7

        /**
         * Safe Args Plugin Id
         */
        const val SAFE_ARGS_PLUGIN_ID ="androidx.navigation.safeargs"
        const val SAFE_ARGS_PLUGIN_ID_KOTLIN ="androidx.navigation.safeargs.kotlin"
    }

}

fun classpathForSafeArgsPlugin(version: String = Navigation.LATEST_VERSION): String {
    return "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
}
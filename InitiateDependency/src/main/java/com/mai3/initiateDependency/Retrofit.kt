package com.mai3.initiateDependency

import org.gradle.api.artifacts.dsl.DependencyHandler

class Retrofit(private val dependencyHandler: DependencyHandler) {


    fun implementationRetrofitWithGsonConverter(version: String = LATEST_VERSION): Retrofit {
        implementationRetrofit(version)
        implementationGsonConverter(version)
        return this
    }

    fun implementationRetrofit(version: String = LATEST_VERSION): Retrofit {
        dependencyHandler.implementation("com.squareup.retrofit2:retrofit:$version")
        return this
    }

    fun implementationGsonConverter(version: String = LATEST_VERSION): Retrofit {
        dependencyHandler.implementation("com.squareup.retrofit2:converter-gson:$version")
        return this
    }

    companion object {
        const val VERSION_2_9_0 = "2.9.0"
        const val LATEST_VERSION = VERSION_2_9_0
    }

}


class Okhttp(private val dependencyHandler: DependencyHandler) {

    fun implementationBom(version: String = Okhttp.LATEST_VERSION) : Okhttp {
        dependencyHandler.implementation(dependencyHandler.platform("com.squareup.okhttp3:okhttp-bom:$version"))
        return this
    }

    fun implementationOkhttpWithLoggingInterceptor() : Okhttp {
        implementationOkhttp()
        implementationLoggingInterceptor()
        return this
    }

    fun implementationOkhttp() : Okhttp {
        dependencyHandler.implementation("com.squareup.okhttp3:okhttp")
        return this
    }

    fun implementationLoggingInterceptor() : Okhttp {
        dependencyHandler.implementation("com.squareup.okhttp3:logging-interceptor")
        return this
    }

    companion object {
        const val VERSION_4_12_0 = "4.12.0"
        const val LATEST_VERSION = VERSION_4_12_0
    }

}
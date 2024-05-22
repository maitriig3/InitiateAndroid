package in_.mai3.initiateDependency

import org.gradle.api.artifacts.dsl.DependencyHandler

class RoomDatabase(private val dependencyHandler: DependencyHandler) {


    fun basicRequired(version: String = LATEST_VERSION): RoomDatabase{
        implementationWithKapt(version)
        implementationKtx(version)
        return this
    }


    fun implementationWithKapt(version: String = LATEST_VERSION): RoomDatabase{
        implementation(version)
        compilerKapt(version)
        return this
    }

    fun implementationWithAnnotationProcessor(version: String = LATEST_VERSION): RoomDatabase{
        implementation(version)
        compilerAnnotationProcessor(version)
        return this
    }

    fun implementationWithKsp(version: String = LATEST_VERSION): RoomDatabase{
        implementation(version)
        compilerKsp(version)
        return this
    }


    /**
     * implementation("androidx.room:room-runtime:$version")
     */
    fun implementation(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.implementation("androidx.room:room-runtime:$version")
        return this
    }

    /**
     * annotationProcessor("androidx.room:room-compiler:$version")
     */
    fun compilerAnnotationProcessor(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.annotationProcessor("androidx.room:room-compiler:$version")
        return this
    }

    /**
     * kapt("androidx.room:room-compiler:$version")
     */
    fun compilerKapt(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.kapt("androidx.room:room-compiler:$version")
        return this
    }

    /**
     * ksp("androidx.room:room-compiler:$version")
     */
    fun compilerKsp(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.ksp("androidx.room:room-compiler:$version")
        return this
    }

    /**
     * implementation("androidx.room:room-ktx:$version")
     */
    fun implementationKtx(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.implementation("androidx.room:room-ktx:$version")
        return this
    }

    /**
     * implementation("androidx.room:room-rxjava2:$version")
     */
    fun implementationRxJava2(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.implementation("androidx.room:room-rxjava2:$version")
        return this
    }

    /**
     * implementation("androidx.room:room-rxjava3:$version")
     */
    fun implementationRxJava3(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.implementation("androidx.room:room-rxjava3:$version")
        return this
    }

    /**
     * implementation("androidx.room:room-guava:$version")
     */
    fun implementationGuava(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.implementation("androidx.room:room-guava:$version")
        return this
    }

    /**
     * testImplementation("androidx.room:room-testing:$version")
     */
    fun testImplementation(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.testImplementation("androidx.room:room-testing:$version")
        return this
    }

    /**
     * implementation("androidx.room:room-paging:$version")
     */
    fun implementationPaging(version: String = LATEST_VERSION): RoomDatabase{
        dependencyHandler.implementation("androidx.room:room-paging:$version")
        return this
    }


    companion object{
        const val VERSION_2_6_1 = "2.6.1"
        const val LATEST_VERSION = VERSION_2_6_1
    }

}
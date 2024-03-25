
# Initiate Android

This is a library and a gradle plugin to kick start the android development in Android Studio. The library contains various classes to initialize different functionalities so that the developer can directly work on core functionalities instead of spending a lot of time on setting up different things in project. It may be searching dependencies, adding it, setting up initial classes. 

The gradle plugin contains details about dependencies so it can be directly added in the build.gradle.

The library and templates present in [Android-Live-File-Templates](https://github.com/maitriig3/Android-Live-File-Templates) are used to setup different libraries required for the app, such as Retrofit, Dagger-Hilt and Connectivity Manager.

### Setup

[//]: # (##### Library)

[//]: # ()
[//]: # (To use the library in your app,)

[//]: # (-> Download the repository by opening the 'Code' option and clicking on the 'Download ZIP')

[//]: # (-> Unzip the file in your preferred directory)

[//]: # (-> Open the project where you want to import InitiateAndroid Library)

[//]: # (-> Go to File -> New -> Import Module and choose the module 'InitiateAndroid' in the unzipped folder)

[//]: # (-> Click on Finish)

##### Gradle Plugin

-> Download the jar file 'InitiateDependency/libs/InitiateDependency.jar'
-> Import the plugin in project level build.gradle

buildscript{
    dependencies{
        classpath(files("..\\InitiateDependency\\libs\\InitiateDependency.jar"))
    }
}

##### Import the Live and File Templates




### Initiate Dagger-Hilt

-> To add the dependency in module level build.gradle file

    import `in`.mai3.initiateDependency.DaggerHilt

    ... 

    dependencies {

        DaggerHilt(this)
            .implementationWithKapt()

    }

-> Add hilt plugin
    -> In project level build.gradle file, add
buildscript{
dependencies{
...
classpath("com.google.dagger:hilt-android-gradle-plugin:LATEST_VERSION")
}
}

    -> In module level build.gradle file, add
    plugins {
        id("com.google.dagger.hilt.android")
    }

-> Use the file template 'InitiateDaggerHilt'. Right click on the root package, go to New and you can find the template
-> After clicking on it, a dialog box is opened asking for input
-> If (InitiateRetrofit) setup is already done and you want to define Retrofit instance in Dagger Hilt module class, then give true to in the dialog. If not, leave it empty.



# Initiate Android

This is a library and a gradle plugin to kick start the android development in Android Studio. The library contains various classes to initialize different functionalities so that the developer can directly work on core functionalities instead of spending a lot of time on setting up different things in project. It may be searching dependencies, adding it, setting up initial classes.

The gradle plugin contains details about dependencies so that it can be directly added in the build.gradle file.
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

- Download the jar file 'InitiateDependency/libs/InitiateDependency.jar'
- Import the plugin in project level build.gradle

```
buildscript{
    dependencies{
        classpath(files("..\\InitiateDependency\\libs\\InitiateDependency.jar"))
    }
}
```

##### Import the Live and File Templates


### Initiate Internet Connectivity

- 'initiateInternetConnectivityInDaggerHilt' live template to define a provides function for ConnectivityRepository in Dagger-Hilt module class.
- 'connParameter' to add parameter to view model.
- 'isInternetConnectedDeclare' to declare live data variables in view model.
- Two ways to get callbacks,
  - Get callbacks everytime internet connectivity changes during the lifecycle: Select a block of code and enclose it with code in 'isInternetConnectedSelect' live template,
    ```
    viewModel.isInternetConnected.observe(viewLifecycleOwner) {
            if (it) {
                // Internet is connected
            }
        }
    ```
  - Get callbacks only for specific number of time: Select a block of code and enclose it with code in 'isInternetConnectedTimesSelect' live template,
    In the below, callbacks are received exactly two times:
    ```
    viewModel.isInternetConnectedNoOfTimes(2).observe(viewLifecycleOwner) {
            if (it) {
                // Internet is connected
            }
        }
    ```

### Initiate Dagger-Hilt

- Add the dependency in module level build.gradle file

  ```  
  import in_.mai3.initiateDependency.DaggerHilt
  
  ... 
  
  dependencies {
  
      DaggerHilt(this)
          .basicRequired()
  
  }
  ```

- Add hilt plugin
  - In project level build.gradle file, add
    ```
    buildscript{
        dependencies{
        ...
        classpath("com.google.dagger:hilt-android-gradle-plugin:LATEST_VERSION")
        }
    }
    ```

  - In module level build.gradle file, add
    ```
    plugins {  
        id("com.google.dagger.hilt.android")
    }
    ```

- Create file in the root package with file template 'InitiateDaggerHilt'
  - Initiate Retrofit : If files related to Retrofit are created, then add the value 'true' and if not, leave it blank.
  - Initiate Room Database : If files related to Room Database are created, then add the value 'true' and if not, leave it blank.
  - Initiate Shared Preferences : If files related to Shared Preferences are created, then add the value 'true' and if not, leave it blank.

### Initiate Retrofit

- Add the dependency in module level build.gradle file
  ```  
  import in_.mai3.initiateDependency.Retrofit
  
  ... 
  
  dependencies {
  
      Retrofit(this)
        .basicRequired()
  
  }
  ```
- Create all files using file template 'InitiateRetrofit', which creates files required to implement Retrofit in 'data/remote'(call from base package)
  - An object 'EndPoints.kt' in which data regarding API endpoints are added
  - A sample request in package 'request'
  - A sample response in package 'response'
  - An interface 'ApiFunctions' which contains one sample POST request and response captured as NetworkData<ResponseSample>
  - A 'NetworkRepository' where functions from ApiFunctions are called and parsed using 'parseResult(...)' function to get NetworkResult.Success or NetworkResult.Error
- Define retrofit builder by calling 'InitializeRetrofit.retrofitBuilder(...)' function, parameters include
  - baseUrl : Base Url of Api
  - classInterface : Interface which contains different request functions
  - successConstant: Verified after getting result with NetworkData.result to know success response in 'parseResponse()' function. Default value is 1.
  - failureConstant: Verified after getting result with NetworkData.result to know failure response in 'parseResponse()' function. Default value is 0.,
  - interceptor: Interceptor to be added to Okhttp Client. Default is HttpLoggingInterceptor with level BODY
  - okHttpClient: OkHttpClient to be added to Retrofit Builder. Default is OkHttpClient with HttpLoggingInterceptor, 60 seconds read and connect timeout.
  - setLenientGson: If 'setLenient()' has to be called on GsonBuilder for GsonConverterFactory. Default is true
- To initialize retrofitBuilder and NetworkRepository in a dagger-hilt module class
  - If module class is already defined, then call live template 'initiateRetrofitInDaggerHilt'
  - If not, add 'true' to 'Initiate Retrofit' in InitiateDaggerHilt
  ```
  @Provides
  @Singleton
  fun providesRetrofitBuilder(): ApiFunctions {
  return InitializeRetrofit.retrofitBuilder(
         BASE_URL,
         ApiFunctions::class.java
       )
  }
  ``` 

#### View Binding Fragment

- Enable view binding in build.gradle or build.gradle.kts
  ```
  buildFeatures{
        viewBinding = true
  }
  ```
- Create layout file for the fragment.
- Create fragment using 'ViewBindingFragment' which extends ViewBindingFragment.
  - File Name: Give the class name; for example, PrintFragment.
  - Layout Binding: Add the binding file of the layout created.

#### Initiate Room Database

- Add the dependency in module level build.gradle file
  ```  
  import in_.mai3.initiateDependency.RoomDatabase
  
  ... 
  
  dependencies {
  
       RoomDatabase(this)
        .basicRequired()
  
  }
  ```
- Use file template 'InitiateRoomDatabase' to get a sample table and AppDatabase in package 'data/local/room' (call from base package)
- To initialize Room Database builder in a dagger-hilt module class
  - If module class is already defined, then call live template 'initiateRoomDatabaseInDaggerHilt'
  - If not, add 'true' to 'Initiate Room Database' in InitiateDaggerHilt

#### Initiate Shared Preferences
- Use file template 'InitiateSharedPreferences' to get an object class and repositories in package 'data/local/preferences' (call from base package)
- To initialize shared preferences, editor and repository in a dagger-hilt module class
  - If module class is already defined, then call live template 'initiateSharedPreferencesInDaggerHilt'
  - If not, add 'true' to 'Initiate Shared Preferences'


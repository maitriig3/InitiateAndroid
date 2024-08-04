package in_.mai3.initiateandroidsample.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import in_.mai3.initiateandroid.connectivityManager.withLiveData.ConnectivityRepository
import in_.mai3.initiateandroid.network.retrofit.InitializeRetrofit
import in_.mai3.initiateandroidsample.data.local.preferences.PreferencesRepository
import in_.mai3.initiateandroidsample.data.local.preferences.PreferencesRepositoryImpl
import in_.mai3.initiateandroidsample.data.remote.ApiFunctions
import in_.mai3.initiateandroidsample.data.remote.EndPoints.BASE_URL
import in_.mai3.initiateandroidsample.data.remote.repository.NetworkRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofitBuilder(): ApiFunctions {
        return InitializeRetrofit.retrofitBuilder(
            BASE_URL,
            ApiFunctions::class.java
        )
    }

    @Provides
    @Singleton
    fun providesNetworkRepository(
        apiFunctions: ApiFunctions,
        context: Application
    ): NetworkRepository {
        return NetworkRepository(apiFunctions, context)
    }

    @Provides
    @Singleton
    fun providesPreferences(context: Application): SharedPreferences{
        return context.getSharedPreferences("in_.mai3.initiateandroidsample.data", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor{
        return sharedPreferences.edit()
    }

    @Provides
    @Singleton
    fun providesPreferenceRepository(sharedPreferences: SharedPreferences,editor: SharedPreferences.Editor): PreferencesRepository {
        return PreferencesRepositoryImpl(sharedPreferences, editor)
    }

    @Provides
    @Singleton
    fun providesConnectivityRepository(context: Application): ConnectivityRepository{
        return ConnectivityRepository(context)
    }

}




package com.mai3.initiateandroidsample.di

import com.mai3.initiateandroid.network.retrofit.InitializeRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofitBuilder(): com.mai3.initiateandroidsample.remote.ApiFunctions {
        return InitializeRetrofit.retrofitBuilder(
            com.mai3.initiateandroidsample.remote.EndPoints.BASE_URL,
            com.mai3.initiateandroidsample.remote.ApiFunctions::class.java
        )
    }

    @Provides
    @Singleton
    fun providesNetworkRepository(
        apiFunctions: com.mai3.initiateandroidsample.remote.ApiFunctions,
        context: android.app.Application
    ): com.mai3.initiateandroidsample.remote.repository.NetworkRepository {
        return com.mai3.initiateandroidsample.remote.repository.NetworkRepository(
            apiFunctions,
            context
        )
    }


}




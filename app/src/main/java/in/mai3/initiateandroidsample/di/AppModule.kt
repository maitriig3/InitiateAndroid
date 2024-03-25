package `in`.mai3.initiateandroidsample.di

import `in`.mai3.initiateandroid.network.retrofit.InitializeRetrofit
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
    fun providesRetrofitBuilder(): `in`.mai3.initiateandroidsample.remote.ApiFunctions {
        return InitializeRetrofit.retrofitBuilder(
            `in`.mai3.initiateandroidsample.remote.EndPoints.BASE_URL,
            `in`.mai3.initiateandroidsample.remote.ApiFunctions::class.java
        )
    }

    @Provides
    @Singleton
    fun providesNetworkRepository(
        apiFunctions: `in`.mai3.initiateandroidsample.remote.ApiFunctions,
        context: android.app.Application
    ): `in`.mai3.initiateandroidsample.remote.repository.NetworkRepository {
        return `in`.mai3.initiateandroidsample.remote.repository.NetworkRepository(
            apiFunctions,
            context
        )
    }


}




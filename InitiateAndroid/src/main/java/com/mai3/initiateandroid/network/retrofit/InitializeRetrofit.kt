package com.mai3.initiateandroid.network.retrofit

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object InitializeRetrofit{

    var successConstant = 1
        private set
    var failureConstant = 0
        private set



    fun <T> retrofitBuilder(
        baseUrl: String,
        classInterface: Class<T>,
        successConstant: Int = 1,
        failureConstant: Int = 0,
        interceptor: Interceptor? = null,
        okHttpClient: OkHttpClient? = null,
        setLenientGson: Boolean = true): T{
        this.successConstant = successConstant
        this.failureConstant = failureConstant
        val httpLoggingInterceptor = interceptor ?:  HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val client = okHttpClient ?: OkHttpClient.Builder().run {
            addInterceptor(httpLoggingInterceptor)
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
            build()
        }

        val gson = if(setLenientGson)
            GsonBuilder().setLenient().create()
        else
            GsonBuilder().create()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build().create(classInterface)
    }

}
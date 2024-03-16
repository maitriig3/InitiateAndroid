package com.mai3.initiateandroid.network.retrofit

import retrofit2.Response

fun <T> parseResult(responseNull: Response<NetworkData<T>>?): NetworkResult<T> {
    return try {
        responseNull?.let { response ->
            if(response.isSuccessful){
                response.body()?.let {
                    when(it.result){
                        InitializeRetrofit.successConstant -> {
                            it.data?.let { data ->
                                NetworkResult.Success(data)
                            }?: NetworkResult.Error(it.message ?: "Unknown error occurred")
                        }
                        InitializeRetrofit.failureConstant -> NetworkResult.Error(it.message ?: "Unknown error occurred")
                        else -> NetworkResult.Error("Unknown error occurred")
                    }
                } ?: NetworkResult.Error("Unknown error occurred")
            }else{
                response.errorBody()?.let {
                    NetworkResult.Error(response.message().toString())
                } ?: NetworkResult.Error("Unknown error occurred")
            }
        } ?: NetworkResult.Error("No Response")

    }catch (e: Exception){
        e.localizedMessage?.let{
            NetworkResult.Error(it)
        } ?:
        NetworkResult.Error(e.message.toString())
    }
}
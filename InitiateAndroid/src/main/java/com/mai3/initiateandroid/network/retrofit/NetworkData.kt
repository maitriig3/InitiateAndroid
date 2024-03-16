package com.mai3.initiateandroid.network.retrofit

import com.google.gson.annotations.SerializedName

data class NetworkData<T>(
    @SerializedName("result")
    val result: Int?,
    @SerializedName("data")
    val data: T?,
    @SerializedName("message")
    val message: String?
)
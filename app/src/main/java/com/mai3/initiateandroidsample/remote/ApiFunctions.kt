package com.mai3.initiateandroidsample.remote

import com.mai3.initiateandroid.network.retrofit.NetworkData
import com.mai3.initiateandroidsample.remote.EndPoints.SAMPLE
import com.mai3.initiateandroidsample.remote.request.RequestSample
import com.mai3.initiateandroidsample.remote.response.ResponseSample
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiFunctions {

    @POST(SAMPLE)
    suspend fun sample(
        @Query("task") task: String,
        @Body requestSample: RequestSample
    ): Response<NetworkData<ResponseSample>>


}
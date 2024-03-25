package `in`.mai3.initiateandroidsample.remote.repository

import android.content.Context
import `in`.mai3.initiateandroid.network.retrofit.NetworkData
import `in`.mai3.initiateandroid.network.retrofit.NetworkResult
import `in`.mai3.initiateandroid.network.retrofit.parseResult
import `in`.mai3.initiateandroidsample.remote.ApiFunctions
import `in`.mai3.initiateandroidsample.remote.request.RequestSample
import retrofit2.Response

class NetworkRepository(private val apiFunctions: ApiFunctions, private val context: Context) {


    suspend fun <T> invokeNetworkCall(
        module: String,
        task: String,
        request: Any
    ): NetworkResult<T> {
        return parseResult(
            apiFunctions.sample(task, request as RequestSample) as Response<NetworkData<T>>
        )
    }

}
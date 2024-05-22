package in_.mai3.initiateandroidsample.data.remote.repository

import android.content.Context
import in_.mai3.initiateandroid.network.retrofit.NetworkResult
import in_.mai3.initiateandroid.network.retrofit.parseResult
import in_.mai3.initiateandroidsample.data.remote.ApiFunctions
import in_.mai3.initiateandroidsample.data.remote.request.RequestSample

class NetworkRepository(private val apiFunctions: ApiFunctions, private val context: Context) {


    suspend fun <T> invokeNetworkCall(
        module: String,
        task: String,
        request: Any
    ): NetworkResult<T> {
        return parseResult(
            apiFunctions.sample(task, request as RequestSample)
        ) as NetworkResult<T>
    }

}
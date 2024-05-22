package in_.mai3.initiateandroidsample.data.remote

import in_.mai3.initiateandroid.network.retrofit.NetworkData
import in_.mai3.initiateandroidsample.data.remote.EndPoints.SAMPLE
import in_.mai3.initiateandroidsample.data.remote.request.RequestSample
import in_.mai3.initiateandroidsample.data.remote.response.ResponseSample
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
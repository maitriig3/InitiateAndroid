package in_.mai3.initiateandroidsample.data.remote.request

import com.google.gson.annotations.SerializedName

data class RequestSample(
    @SerializedName("versionsave")
    var versionsave: String,
    @SerializedName("sample")
    val sample: String,
)
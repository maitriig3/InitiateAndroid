package `in`.mai3.initiateandroid.connectivityManager.withLiveData

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.take

class ConnectivityRepository(val context: Context) {


    private val connectivityManager = context.getSystemService(ConnectivityManager::class.java) as ConnectivityManager
    private val networkRequest: NetworkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()


    private val isInternetConnected = callbackFlow {
        var isUnavailable = true
        val networkCallback = object: ConnectivityManager.NetworkCallback(){
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                isUnavailable = false
                trySend(true)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                trySend(false)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                trySend(false)
            }
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            connectivityManager.requestNetwork(networkRequest,networkCallback,100)
//        }else{
//            kotlinx.coroutines.delay(100L)
//            if(isUnavailable)
//                trySend(false)
//        }
        connectivityManager.registerNetworkCallback(networkRequest,networkCallback)
//        connectivityManager.requestNetwork(networkRequest,networkCallback)
        kotlinx.coroutines.delay(100L)
        if(isUnavailable)
            trySend(false)
        awaitClose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }


    val isInternetConnectedLiveData = isInternetConnected.asLiveData()

    /**
     * Create a function while calling this
     *
     * [noOfTimes] = 1 : when a button is pressed and have to know only once whether internet is connected to proceed or give message if not
     * [noOfTimes] = 2 : Two cases
     *               -> First time when internet is not connected, to give message to connect
     *                  And if internet is connected at any point in lifecycle, then get update to do api call
     *                  This works when data has to be loaded automatically when internet is connected without user intervention
     *               -> If internet is connected at the start, then if internet is disconnected at any point in lifecycle, then update is got
     *                  If there's no need to get second update, then remove observer first time when internet is connected
     *
     *                  val liveData =  viewModel.isInternetConnectedNoOfTimes(2)
     *                  liveData.observe(viewLifecycleOwner){
     *                      if(it){
     *                          liveData.removeObservers(viewLifecycleOwner)
     *                          /** ... **/
     *                      }else{
     *                          /** ... **/
     *                      }
     *                  }
     *
     */
    fun isInternetConnectedNoOfTimesLiveData(noOfTimes: Int = 1) = isInternetConnected.take(noOfTimes).asLiveData()


}
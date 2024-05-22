package in_.mai3.initiateandroid.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

fun String.logE(tag: String = "Error"){
    Log.e(tag, this)
}

fun String.toast(context: Context, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,length).show()
}
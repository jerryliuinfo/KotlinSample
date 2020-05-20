package com.apache.kotlin.util

import android.util.Log

/**
 * Created by Jerry on 2020-04-18.
 */
object LogUtils {
    val TAG = "  "
    fun d(msg:String){
        Log.d(TAG, msg)
    }
}
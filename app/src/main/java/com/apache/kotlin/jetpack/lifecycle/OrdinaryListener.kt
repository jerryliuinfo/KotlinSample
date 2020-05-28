package com.apache.kotlin.jetpack.OrdinaryListener

import android.content.Context
import com.apache.kotlin.jetpack.lifecycle.IlifeCycle
import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-05-28.
 */
class OrdinaryListener(val context:Context):IlifeCycle {
    override fun onCreate() {
        LogUtils.d("OrdinaryListener call onCreate")
    }

    override fun onStart() {
        LogUtils.d("OrdinaryListener call onStart")
    }

    override fun onResume() {
        LogUtils.d("OrdinaryListener call onResume")
    }

    override fun onPause() {
        LogUtils.d("OrdinaryListener call onPause")

    }

    override fun onStop() {
        LogUtils.d("OrdinaryListener call onStop")

    }

    override fun onDestroy() {
        LogUtils.d("OrdinaryListener call onDestroy")

    }


}
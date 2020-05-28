package com.apache.kotlin.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.apache.kotlin.util.LogUtils


/**
 * Created by Jerry on 2020-05-26.
 */
class LifeCycleListener:LifecycleObserver,IlifeCycle {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onCreate() {
        LogUtils.d("Lifecycle call onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        LogUtils.d("Lifecycle call onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
        LogUtils.d("Lifecycle call onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
        LogUtils.d("Lifecycle call onPause")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
        LogUtils.d("Lifecycle call onStop")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        LogUtils.d("Lifecycle call onDestroy")

    }

}
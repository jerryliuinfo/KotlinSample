package com.apache.kotlin.jetpack.lifecycle

/**
 * Created by Jerry on 2020-05-28.
 */
interface IlifeCycle {
    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}
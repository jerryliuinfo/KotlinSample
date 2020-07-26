package com.apache.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apache.kotlin.jetpack.OrdinaryListener.OrdinaryListener
import com.apache.kotlin.jetpack.lifecycle.LifeCycleListener
import com.apache.kotlin.usage.VodApplicationLifeCallback
import com.apache.kotlin.util.LogUtils
import kotlinx.android.synthetic.main.activity_main.*


open  class MainActivity : AppCompatActivity(R.layout.activity_main) {


    lateinit var mListener:OrdinaryListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mListener = OrdinaryListener(this)

        mListener.onCreate()

        lifecycle.addObserver(LifeCycleListener())

        textView.setOnClickListener {
            LogUtils.d("onclik")

            LogUtils.d("onclik")
        }

        VodApplicationLifeCallback.instance.registerApplicationCallback()

    }


    override fun onResume() {
        super.onResume()
        mListener.onResume()
    }

    override fun onPause() {
        super.onPause()
        mListener.onPause()
    }


    override fun onStop() {
        super.onStop()
        mListener.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mListener.onDestroy()
    }





}

package com.apache.kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apache.kotlin.bibibili.chapter01.Chapter01DemoActivity
import com.apache.kotlin.jetpack.OrdinaryListener.OrdinaryListener
import com.apache.kotlin.jetpack.lifecycle.LifeCycleListener
import com.apache.kotlin.usage.VodApplicationLifeCallback
import com.apache.kotlin.util.LogUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread


open  class MainActivity : AppCompatActivity(R.layout.activity_main) {


    lateinit var mListener:OrdinaryListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mListener = OrdinaryListener(this)

        mListener.onCreate()

        lifecycle.addObserver(LifeCycleListener())

        tv_message.setOnClickListener {
            LogUtils.d("onclik")
            val intent = Intent(this@MainActivity, Chapter01DemoActivity::class.java)
            startActivity(intent)
        }

        VodApplicationLifeCallback.instance.registerApplicationCallback()


       /* thread {
            ioCode1()
            runOnUiThread {
                uiCode1()
                thread {
                    ioCode2()
                    runOnUiThread {
                        uiCode2()
                        thread {
                            ioCode3()
                            runOnUiThread {
                                uiCode3()
                            }
                        }
                    }
                }
            }
        }*/
        GlobalScope.launch(Dispatchers.Main) {
            ioCode1()
            uiCode1()
            ioCode2()
            uiCode2()
            ioCode3()
            uiCode3()
        }




    }


    private suspend fun ioCode1() {
        withContext(Dispatchers.IO){
            println("Coroutines Camp io1 ${Thread.currentThread().name}")
        }
    }

    private suspend  fun ioCode2() {
        withContext(Dispatchers.IO){
            println("Coroutines Camp io2 ${Thread.currentThread().name}")
        }
    }

    private suspend  fun ioCode3() {
        withContext(Dispatchers.IO){
            println("Coroutines Camp io3 ${Thread.currentThread().name}")
        }
    }

    private fun uiCode1() {
        println("Coroutines Camp ui1 ${Thread.currentThread().name}")
    }

    private fun uiCode2() {
        println("Coroutines Camp ui2 ${Thread.currentThread().name}")
    }

    private fun uiCode3() {
        println("Coroutines Camp ui3 ${Thread.currentThread().name}")
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

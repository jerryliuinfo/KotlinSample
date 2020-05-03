package com.apache.kotlin.coroutines

import com.apache.kotlin.arraylist.ArrayListDemo
import com.apache.kotlin.util.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

/**
 * Created by Jerry on 2020-04-22.
 */
class CoroutinesDay1 {
    fun test(){
        thread {
            LogUtils.d("Coroutines Camp1: ${Thread.currentThread().name}")
        }
        Thread(){
            LogUtils.d("Coroutines Camp2: ${Thread.currentThread().name}")

        }.start()

        GlobalScope.launch (Dispatchers.Main){
            LogUtils.d("CoroutinesDemo 111:${Thread.currentThread().name}")
            IO1()
            UI1()
            IO2()
            UI2()
            IO3()
            UI3()
        }
        val arrayListDemo = ArrayListDemo()
        arrayListDemo.test()


    }

    private suspend fun  IO1(){
        withContext(Dispatchers.IO){
            Thread.sleep(1000)
            LogUtils.d("IO1 :${Thread.currentThread().name}")
        }

    }
    private suspend fun IO2(){
        withContext(Dispatchers.IO){
            Thread.sleep(1000)
            LogUtils.d("IO2 :${Thread.currentThread().name}")
        }
    }
    private suspend  fun IO3(){
        withContext(Dispatchers.IO){
            Thread.sleep(1000)
            LogUtils.d("IO3 :${Thread.currentThread().name}")
        }
    }


    private fun UI1(){
        LogUtils.d("UI1 :${Thread.currentThread().name}")
    }
    private fun UI2(){
        LogUtils.d("UI2 :${Thread.currentThread().name}")
    }
    private fun UI3(){
        LogUtils.d("UI3 :${Thread.currentThread().name}")
    }
}
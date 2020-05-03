package com.apache.kotlin.coroutines

import com.apache.kotlin.api.Api
import com.apache.kotlin.bean.Repo
import com.apache.kotlin.util.LogUtils
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Jerry on 2020-05-01.
 */
class CoroutinesDay2 {
    fun test(){
        GlobalScope.launch {
            IO1()
            UI1()
        }


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
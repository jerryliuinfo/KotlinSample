package com.apache.kotlin.karaoke

import android.content.Context
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * author: jerry
 * created on: 2020/6/20 5:32 PM
 * description:
 */
object KotlinDemo{

    fun check(context: Context, callback : (isConfirm : Boolean) -> Unit?) : Boolean{
        return true
    }

    private var schedulerBussinessThreadPool: ThreadPoolExecutor

    init {
        schedulerBussinessThreadPool = ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS,
            LinkedBlockingQueue<Runnable>(), ThreadFactory {
                Thread(it, "SchedulerBussiness")
            })
        schedulerBussinessThreadPool.allowCoreThreadTimeOut(true)
    }

}

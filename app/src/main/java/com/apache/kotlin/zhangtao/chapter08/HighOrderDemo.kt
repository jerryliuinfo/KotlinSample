package com.apache.kotlin.zhangtao.chapter08

/**
 * Created by Jerry on 2020-04-27.
 */
inline fun onlyif(isDebug:Boolean, block:() ->Unit){
    if (isDebug)  block()

}

fun main(args: Array<String>) {
    onlyif(true){
        println("打印日志")
    }

    val runnable = Runnable {
        println("Runnable::run")
    }
    val function: () ->Unit

    function = runnable::run

    onlyif(true,function)
}



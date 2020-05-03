package com.apache.kotlin.zhangtao.chapter09

/**
 * Created by Jerry on 2020-04-27.
 */
class SingleInstanceDemo private constructor(){
    companion object{
        fun get():SingleInstanceDemo{
            return Holder.instance
        }
    }

    private object Holder{
        val instance = SingleInstanceDemo()
    }
}

fun main(args: Array<String>) {
    SingleInstanceDemo.get()
}
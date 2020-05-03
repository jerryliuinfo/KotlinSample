package com.apache.kotlin.arraylist

import com.apache.kotlin.util.LogUtils
import java.util.*

/**
 * Created by Jerry on 2020-04-22.
 */
class ArrayListDemo {

    fun  test(){
        val intArray = intArrayOf(1, 2, 3)
        val listOf = listOf("a", "b", "c")
        LogUtils.d("intArrayOf:${intArray}, listOf:$listOf")

        intArray.forEach { i ->
            LogUtils.d("forEach:${i}")
        }


        var filterNewArray = intArray.filter { i ->
             i != 1
        }
        LogUtils.d("filter newArray:$filterNewArray")


        var mapNewArray = intArray.map { i -> i * 2 }
        LogUtils.d("mapNewArray:$mapNewArray") //{2,4,6}

        var flatMapNewArray = intArray.flatMap { i -> listOf("${i+1}", "a") }
        LogUtils.d("flatMapNewArray:$flatMapNewArray") //{"2", "a" , "3", "a", "4", "a"}

        var range:IntRange = 0..1000
        LogUtils.d("range:$range")
    }
}
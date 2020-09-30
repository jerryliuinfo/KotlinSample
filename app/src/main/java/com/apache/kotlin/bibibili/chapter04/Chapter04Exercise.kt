package com.apache.kotlin.bibibili.chapter04

import android.content.Context
import android.widget.Button
import android.widget.TextView

/**
 * author: jerry
 * created on: 2020/7/26 6:05 PM
 * description:
 */
fun main() {



}

private fun <T> fill(to:Array<in T>, from:T){
    to[0] = from
}


fun <T> copy(from:Array<T>, to:Array<in T>){
    for (index in from.indices) {
        to[index] = from[index]
    }
}




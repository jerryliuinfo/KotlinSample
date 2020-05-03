package com.apache.kotlin.zhangtao.chapter11

/**
 * Created by Jerry on 2020-04-27.
 */
data class DataClass(var id:Int,var name:String)

fun main(args: Array<String>) {
    val dataClass = DataClass(1,"Jerry")
    println(dataClass.toString()) //DataClass(id=1, name=Jerry)
}
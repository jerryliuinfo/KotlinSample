package com.apache.kotlin.hencoder.chapter01

import java.util.Collections.copy

/**
 * Created by Jerry on 2020-05-25.
 */




interface Source<out T>{
    fun nextT(): T
}

fun  varianceDemo(strs:Source<String>){
    val objects:Source<Any> = strs
}


fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
}




interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun contravariantDemo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, we can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}